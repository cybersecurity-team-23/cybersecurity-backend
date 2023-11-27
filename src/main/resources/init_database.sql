DO $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'booking_baboon_database') THEN
    CREATE DATABASE booking_baboon_database;
END IF;
END $$;

DO $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM pg_user WHERE usename = 'booking_baboons') THEN
    CREATE USER booking_baboons WITH PASSWORD 'm0nk3';
    GRANT ALL PRIVILEGES ON DATABASE booking_baboon_database TO booking_baboons;
END IF;
END $$;