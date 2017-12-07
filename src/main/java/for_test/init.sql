CREATE TABLE pet (
  pet_id   INT(10),
  pet_name VARCHAR(20),
  master_id INT(10)
);

INSERT INTO pet( pet_name, master_id)
VALUES ('小花',1),
  ('小花',1),
  ('秋收',2),
  ('夏天',3);

CREATE TABLE toy(
  toy_id   INT(10),
  toy_name VARCHAR(20),
  pet_id INT(10)
);

INSERT INTO toy (toy_name, pet_id)
VALUES
  ('玩具车', 1),
  ('玩具车2', 1),
  ('玩具车3', 1),
  ('皮卡', 2),
  ('皮卡2', 2),
  ('变形金刚', 3);