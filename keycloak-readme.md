1. Start keycloak: docker-compose up --detach
2. Init keycloak (wait ~30s after starting keycloak to run this): python keycloak-init.py
3. Connect keycloak to ldap
    1. Admin console: http://localhost:8090/admin admin:admin
    2. Switch to bookingrealm realm
    3. User federation (sidebar) > Add Ldap Providers  
        UI display name: OpenLDAP  
        Connection url: ldap://localhost_of_the_**host**_machine:389 (ldap://192.168.whatever:389)  
        Test connection  
        Bind dn: cn=admin,dc=test,dc=local
        Bind credentials: admin  
        Test authentication  
        Edit mode: WRITEABLE  
        Users DN: ou=users,dc=test,dc=local  
        Username LDAP attribute: uid  
        RDN LDAP attribute: uid  
        UUID LDAP attribute: uid  
        User object classes: inetOrgPerson,organizationalPerson,person,top
        Enable periodic full sync  
        Save  
4. Creating users directory in ldap  
    1. start apache directory studio  
    2. connect to ldap  
    3. Right click dc=test,dc=local > New > New Entry  
    4. Create entry from scratch > Next  
    5. Add organizationalUnit object class > Next  
    6. RDN: ou=users > Next  
    7. Finish   
5. Map keycloak attributes to ldap
    1. User federation > OpenLDAP > Mappers
    2. there should be email, address, first name, last name, phone number and username (everything else leave as is)  
        ones that dont exist create  
        all should have "Always Read Value From LDAP" ticked and should be "user-attribute-ldap-mapper"   
        ldap attribute mapping to ldap attribute:   
        email:mail  
        address:postalAddress  
        first name:givenName  
        last name:sn  
        phone number:telephoneNumber  
        username:cn  
6. TOTP always required
    1. Authentication (sidebar)
    2. Flows>browser
    3. At the bottom 'Browser - Conditional OTP' - change to 'required'
7. Unmanaged attributes
    1. Realm settings (sidebar)
    2. Unamanaged Attributes - **Enabled**

Login url:
http://localhost:8090/realms/bookingrealm/protocol/openid-connect/auth?client_id=booking-login-app&redirect_uri=http://localhost:4200&response_mode=fragment&response_type=code
