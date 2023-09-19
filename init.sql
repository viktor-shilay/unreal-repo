CREATE SCHEMA IF NOT EXISTS department;
CREATE TABLE IF NOT EXISTS department.employees
(
	id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(64) NOT NULL UNIQUE,
    firstname  VARCHAR(64),
    lastname   VARCHAR(64),
    birth_date DATE,
    role       VARCHAR(32)
);
INSERT INTO department.employees VALUES 
(1, 'v_shilay', 'Viktor', 'Shilay', '1996-01-22', 'UNEMPLOYED'),
(2, 's_kalashynski', 'Siarhei', 'Kalashynski', '1999-03-17', 'PM'),
(3, 'd_nevar', 'Dmitry', 'Nevar', '1993-03-02', 'JAVA_DEV'),
(4, 'e_dolgiy', 'Evgeniy', 'Dolgiy', '1995-06-07', 'JAVA_DEV'),
(5, 'a_medvedev', 'Artyom', 'Medvedev', '2000-04-01', 'UNEMPLOYED'); 
