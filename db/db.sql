CREATE DATABASE IF NOT EXISTS many_to_one_lesson;
USE many_to_one_lesson;

CREATE TABLE IF NOT EXISTS engines (
  id    INT NOT NULL AUTO_INCREMENT,
  model VARCHAR(25) NOT NULL,
  power INTEGER     NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO engines (model, power) VALUES ('model_test', 123);

CREATE TABLE IF NOT EXISTS cars (
  id        INT NOT NULL AUTO_INCREMENT,
  mark      VARCHAR(25) NOT NULL,
  model     VARCHAR(25) NOT NULL,
  engine_id INTEGER     NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (engine_id) REFERENCES engines (id)
);

INSERT INTO  cars (mark, model, engine_id) VALUES ('car_test', 'test_model', 1);