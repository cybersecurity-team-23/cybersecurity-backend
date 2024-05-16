import requests
import json
from urllib.parse import urlencode

KEYCLOAK_ADMIN_USERNAME = 'admin'
KEYCLOAK_ADMIN_PASSWORD = 'admin'
KEYCLOAK_BASE_URL = 'http://localhost:8090'

def get_jwt():
    url = f"{KEYCLOAK_BASE_URL}/realms/master/protocol/openid-connect/token"
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded'
    }
    data = {
        "username": "admin",
        "password": "admin",
        "client_id": "admin-cli",
        "grant_type": "password",
    }
    response = requests.post(url, headers=headers, data=urlencode(data))
    if response.status_code == 200:
        print("Successfully got JWT token")
        access_token = json.loads(response.text)["access_token"]
        return access_token
    else:
        print(f"Failed to get JWT TOKEN Status code: {response.status_code}, Error: {response.text}")

def create_realm(realm_name, token):
    url = f"{KEYCLOAK_BASE_URL}/admin/realms"
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {token}',
    }
    data = {
        "realm": realm_name,
        "enabled": True
    }
    response = requests.post(url, headers=headers, data=json.dumps(data))
    if response.status_code == 201:
        print(f"Realm '{realm_name}' created successfully.")
    else:
        print(f"Failed to create realm. Status code: {response.status_code}, Error: {response.text}")

def create_client(realm_name, client_name, client_id, token, redirect_uri):
    url = f"{KEYCLOAK_BASE_URL}/admin/realms/{realm_name}/clients"
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {token}'
    }
    data = {
        "protocol": "openid-connect",
        "clientId": client_id,
        "name": client_name,
        "enabled": True,
        "secret": token,
        "redirectUris": redirect_uri
    }
    response = requests.post(url, headers=headers, data=json.dumps(data))
    if response.status_code == 201:
        print(f"Client '{client_name}' created successfully.")
    else:
        print(f"Failed to create client. Status code: {response.status_code}, Error: {response.text}")

# NOTE: code not tested
# def create_user(realm_name, username, password, roles=[]):
#     url = f"{KEYCLOAK_BASE_URL}{realm_name}/users"
#     headers = {
#         'Content-Type': 'application/json'
#     }
#     data = {
#         "username": username,
#         "enabled": True,
#         "credentials": [{
#             "type": "password",
#             "value": password
#         }],
#         "realmRoles": roles
#     }
#     response = requests.post(url, headers=headers, data=json.dumps(data), auth=(KEYCLOAK_ADMIN_USERNAME, KEYCLOAK_ADMIN_PASSWORD))
#     if response.status_code == 201:
#         print(f"User '{username}' created successfully.")
#     else:
#         print(f"Failed to create user. Status code: {response.status_code}, Error: {response.text}")

# def create_role(realm_name, role_name):
#     url = f"{KEYCLOAK_BASE_URL}{realm_name}/roles"
#     headers = {
#         'Content-Type': 'application/json'
#     }
#     data = {
#         "name": role_name
#     }
#     response = requests.post(url, headers=headers, data=json.dumps(data), auth=(KEYCLOAK_ADMIN_USERNAME, KEYCLOAK_ADMIN_PASSWORD))
#     if response.status_code == 201:
#         print(f"Role '{role_name}' created successfully.")
#     else:
#         print(f"Failed to create role. Status code: {response.status_code}, Error: {response.text}")

if __name__ == "__main__":
    token = get_jwt()
    create_realm("bookingrealm", token)
    create_client("bookingrealm", "booking-login-app", "booking-login-app", token, ["http://localhost:4200/"])

    # TODO: roles, user
    # create_role("example_realm", "example_role")
    # create_user("example_realm", "example_user", "user_password", roles=["example_role"])
