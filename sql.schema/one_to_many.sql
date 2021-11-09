CREATE DATABASE IF NOT EXISTS one_to_many_lesson;
USE one_to_many_lesson;

CREATE TABLE IF NOT EXISTS cars (
  id   INT NOT NULL AUTO_INCREMENT,
  cost INT,
  mark VARCHAR(25),
  PRIMARY KEY (id)
);

INSERT INTO cars (mark, cost) VALUES ('ford', 100000);
INSERT INTO cars (mark, cost) VALUES ('ford', 10984673);
INSERT INTO cars (mark, cost) VALUES ('mazda', 10984673);

CREATE TABLE IF NOT EXISTS engines (
  id       INT NOT NULL AUTO_INCREMENT,
  name     VARCHAR(25),
  power    INT,
  car_mark VARCHAR(25),
  PRIMARY KEY (id)
);

INSERT INTO engines (name, power, car_mark) VALUES ('super-engine', 10000, 'ford');