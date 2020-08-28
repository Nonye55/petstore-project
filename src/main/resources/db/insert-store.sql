SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE Store;
TRUNCATE TABLE pet;

INSERT INTO store(`id`,`store_name`,`store_number`,`address`,`city`,`state`,`country`)
VALUES(301,'cool-stores',5,'321 sabo street,Canada','west', 'Ondo','Italy'),
(302,'petsonly-stores',6,'34 yaba road,USA','Lagos', 'Oba','North-America'),
(304,'pet-vent-stores',7,'45 onike street,Aba','Umahia', 'Awka','South-Africa'),
(305,'lovepet-stores', 8 ,'65 northwest road,Canada','abloegba','Akwa-Ibom','USA'),
(306,'pettech-stores',9 ,'100 lekki way,Lagos','Lekki', 'Ibadan','Nigeria');

SET FOREIGN_KEY_CHECKS = 1;
