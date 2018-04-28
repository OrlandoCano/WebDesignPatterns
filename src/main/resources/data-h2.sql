DROP TABLE PERSON;
CREATE TABLE IF NOT EXISTS person (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

INSERT INTO person VALUES (1, 'Orlando Cano', 'orlando.cano@gmail.com');
INSERT INTO person VALUES (2, 'Petronilo Lopez', 'petronilo_lopez@gmail.com');
INSERT INTO person VALUES (3, 'Josefa Ortiz', 'josefa_ortiz@gmail.com');