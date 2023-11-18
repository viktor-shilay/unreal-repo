CREATE SCHEMA IF NOT EXISTS department;
CREATE TABLE IF NOT EXISTS department.employees
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(64) NOT NULL UNIQUE,
    firstname  VARCHAR(64) NOT NULL,
    lastname   VARCHAR(64) NOT NULL,
    birth_date DATE        NOT NULL,
    role       VARCHAR(32) NOT NULL
);
INSERT INTO department.employees
VALUES (1, 'v_shilay', 'Viktor', 'Shilay', '1996-01-22', 'UNEMPLOYED'),
       (2, 's_kalashynski', 'Siarhei', 'Kalashynski', '1999-03-17', 'PM'),
       (3, 'd_nevar', 'Dmitry', 'Nevar', '1993-03-02', 'JAVA_DEV'),
       (4, 'e_dolgiy', 'Evgeniy', 'Dolgiy', '1995-06-07', 'JAVA_DEV'),
       (5, 'a_medvedev', 'Artyom', 'Medvedev', '2000-04-01', 'UNEMPLOYED');

CREATE TABLE IF NOT EXISTS department.cars
(
    id               BIGSERIAL PRIMARY KEY,
    brand            VARCHAR(64) NOT NULL,
    model            VARCHAR(64) NOT NULL,
    manufacture_year INTEGER     NOT NULL CHECK (manufacture_year > 1950 AND manufacture_year < EXTRACT(YEAR FROM NOW())),
    engine_type      VARCHAR(32) NOT NULL,
    color            VARCHAR(64) NOT NULL,
    price            DECIMAL     NOT NULL,
    employee_id      BIGINT REFERENCES department.employees (id)
);

INSERT INTO department.cars
VALUES (1, 'Volkswagen', 'Passat(B8)', '2020', 'Diesel', 'Gray', 27450.0, 5),
       (2, 'Audi', 'A5(F5)', '2020', 'Petrol', 'Black', 43000.0, 1),
       (3, 'Tesla', 'Model X (I)', '2016', 'Electric', 'White', 41900.5, 2),
       (4, 'Mercedes-Benz', 'C-Class(W205)', '2014', 'Petrol', 'Black', 23000.0, 3),
       (5, 'Mazda', 'CX-30(DM) EV', '2021', 'Electric', 'Blue', 23900.0, 4),
       (6, 'Land Rover', 'Discovery IV', '2013', 'Petrol', 'Red', 34000.0, 3),
       (7, 'BMW', '4 Series (F32/F33) 430i', '2019', 'Petrol', 'Black', 31000, 1),
       (8, 'Peugeot', '406 I', '1997', 'Petrol', 'Red', 1600, 4),
       (9, 'Ford', 'Mustang VI Premium', '2017', 'Petrol', 'Red', 40000.0, 2),
       (10, 'Honda', 'eNS1 (I) 69kW E-Motion', '2022', 'Electric', 'White', 35000.0, 3);
