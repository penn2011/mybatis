CREATE TABLE pet (
  pet_id   INT(10),
  pet_name VARCHAR(20),
  master_id INT(10)
);

INSERT INTO pet( pet_name, master_id)
VALUES ('С��',1),
  ('С��',1),
  ('����',2),
  ('����',3);

CREATE TABLE toy(
  toy_id   INT(10),
  toy_name VARCHAR(20),
  pet_id INT(10)
);

INSERT INTO toy (toy_name, pet_id)
VALUES
  ('��߳�', 1),
  ('��߳�2', 1),
  ('��߳�3', 1),
  ('Ƥ��', 2),
  ('Ƥ��2', 2),
  ('���ν��', 3);