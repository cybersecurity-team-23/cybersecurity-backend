INSERT INTO public.users (
    id, address, email, first_name, is_blocked, last_name, password, phone_number
) VALUES
      (1, '123 Main St', 'john.doe@example.com', 'John', false, 'Doe', 'password123', '+3815551234'),
      (2, '456 Oak St', 'jane.smith@example.com', 'Jane', false, 'Smith', 'securepass', '+3815555678'),
      (3, '789 Pine St', 'bob.johnson@example.com', 'Bob', true, 'Johnson', 'pass123', '+3815559876'),
      (4, '321 Elm St', 'alice.williams@example.com', 'Alice', false, 'Williams', 'alicespass', '+3815554321'),
      (5, '654 Birch St', 'charlie.brown@example.com', 'Charlie', true, 'Brown', 'charliespass', '+3815558765'),
      (6, '987 Cedar St', 'eva.miller@example.com', 'Eva', false, 'Miller', 'evasspass', '+3815552109'),
      (7, '135 Maple St', 'david.davis@example.com', 'David', true, 'Davis', 'davidspass', '+3815553456'),
      (8, '246 Pine St', 'grace.jones@example.com', 'Grace', false, 'Jones', 'gracesspass', '+3815557890'),
      (9, '579 Oak St', 'frank.white@example.com', 'Frank', true, 'White', 'franksspass', '+3815559034'),
      (10, '802 Walnut St', 'helen.martin@example.com', 'Helen', false, 'Martin', 'helenspass', '+3815551230')
    ON CONFLICT (id) DO UPDATE
        SET
            address = EXCLUDED.address,
            email = EXCLUDED.email,
            first_name = EXCLUDED.first_name,
            is_blocked = EXCLUDED.is_blocked,
            last_name = EXCLUDED.last_name,
            password = EXCLUDED.password,
            phone_number = EXCLUDED.phone_number;

INSERT INTO public.hosts (id) VALUES
      (1),
      (2),
      (3),
      (4)
    ON CONFLICT (id) DO NOTHING;

INSERT INTO public.guests (id) VALUES
       (5),
       (6),
       (7),
       (8),
       (9)
    ON CONFLICT (id) DO NOTHING;

INSERT INTO public.admin (id) VALUES
    (10)
    ON CONFLICT (id) DO NOTHING;


UPDATE public.primary_keys
SET value_pk = 11
WHERE key_pk = 'user';


COMMIT;