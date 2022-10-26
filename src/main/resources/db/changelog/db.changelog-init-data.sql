--liquibase formatted sql
--changeset 200688:initial-data splitStatements:true endDelimiter:;
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Paper', 0.5, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Pencil', 8.45, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Water', 2, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Orange Juice', 18.95, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Milk', 13, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Banana', 8.95, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Chocolate Bar', 14.50, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Nuts', 60, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Eraser', 15, current_timestamp, false);
INSERT INTO stock(name, current_price, last_update, deleted) VALUES('Toblerone', 35, current_timestamp, false);
