BEGIN;


DROP TABLE IF EXISTS buyers_details CASCADE;
CREATE TABLE buyers_details (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO buyers_details (name) VALUES
("Mike"),
("Boris");

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, item VARCHAR(255), price INT, buyers_id bigint REFERENCES buyers_details (id));
INSERT INTO products (item, price, buyers_id) VALUES
("GeForce 3080", 500, 1),
("AMD ryzen 5 3600", 400, 1),
("PlayStation 5", 800, 2);

COMMIT;

