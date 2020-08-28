SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE pet;

INSERT INTO pet(`id`,`name`,`breed`,`types`,`sex`,`age`)
VALUES(200,'body','Bingo','RABBIT','MALE', 12),
(201,'body','bobb','GOAT','MALE', 12),
(203,'body','boby','SNAKES','MALE', 12),
(202,'body','green shepared','BIRDS','MALE', 12),
(204,'body','green shepared','RAT','MALE', 12);

SET FOREIGN_KEY_CHECKS = 1;


