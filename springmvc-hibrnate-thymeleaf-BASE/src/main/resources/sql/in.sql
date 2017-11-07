INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 17, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (2, 17, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (3, 17, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 21, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (2, 21, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 23, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 25, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 27, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 29, 'Ириновский');
INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (48, 31, 'Ириновский');

INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('нет данных', 1, 2);
INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль на связке', 2, 2);
INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль на связке', 1, 3);
INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль на связке', 2, 3);
INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль от 1 и 3 пар', 1, 5);
INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('аварийка энтузиастов', 2, 5);
INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль от 1 и 3 пар', 3, 5);

INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Ключ не проверил', 2);
INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Провери 20.11.17, подходит', 2);
INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Здесь был я (админ)', 5);
INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('никому не интересно', 5);
INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Забаню!!!', 5);