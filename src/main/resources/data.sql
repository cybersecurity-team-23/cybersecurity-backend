INSERT INTO public.users (
    id, address, email, first_name, is_blocked, last_name, password, phone_number
) VALUES
      (1, '123 Main St', 'john.doe@example.com', 'John', false, 'Doe', 'password123', '+3815551234'),
      (2, '456 Oak St', 'jane.smith@example.com', 'Jane', false, 'Smith', 'securepass', '+3815555678'),
      (3, '789 Pine St', 'bob.johnson@example.com', 'Bob', true, 'Johnson', 'pass123', '+3815559876'),
      (4, '321 Elm St', 'alice.williams@example.com', 'Alice', false, 'Williams', 'alicespass', '+3815554321'),
      (5, '654 Birch St', 'charlie.brown@example.com', 'Charlie', false, 'Brown', 'charliespass', '+3815558765'),
      (6, '987 Cedar St', 'eva.miller@example.com', 'Eva', false, 'Miller', 'evasspass', '+3815552109'),
      (7, '135 Maple St', 'david.davis@example.com', 'David', false, 'Davis', 'davidspass', '+3815553456'),
      (8, '246 Pine St', 'grace.jones@example.com', 'Grace', false, 'Jones', 'gracesspass', '+3815557890'),
      (9, '579 Oak St', 'frank.white@example.com', 'Frank', false, 'White', 'franksspass', '+3815559034'),
      (10, '802 Walnut St', 'helen.martin@example.com', 'Helen', false, 'Martin', 'helenspass', '+3815551230')
    ON CONFLICT (id) DO NOTHING;

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
SET value_pk = (select count(*)+1 from users)
WHERE key_pk = 'user';

INSERT INTO public.notifications(id, is_read, message, time_created, type, user_id)
VALUES
    (1, false, 'Reservation has been created', CURRENT_TIMESTAMP, 0, 5),
    (2, true, 'Reservation has been cancelled', CURRENT_TIMESTAMP, 1, 5),
    (3, false, 'You received a host review', CURRENT_TIMESTAMP, 2, 6),
    (4, true, 'You received an accommodation review', CURRENT_TIMESTAMP, 3, 7),
    (5, false, 'Host responded to your reservation request', CURRENT_TIMESTAMP, 4, 1)
    ON CONFLICT (id) DO NOTHING;

UPDATE public.primary_keys
SET value_pk = (select count(*)+1 from notifications)
WHERE key_pk = 'notification';

COMMIT;