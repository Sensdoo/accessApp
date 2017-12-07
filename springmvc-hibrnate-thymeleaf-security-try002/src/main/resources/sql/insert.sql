#------roles
INSERT INTO role (NAME) VALUES ('ROLE_USER');

#------streets
INSERT INTO street (name) VALUES ('2-Я Жерновская');
INSERT INTO street (name) VALUES ('3-Я Жерновская');
INSERT INTO street (name) VALUES ('6-Я Жерновская');
INSERT INTO street (name) VALUES ('Индустриальный');
INSERT INTO street (name) VALUES ('Ириновский');
INSERT INTO street (name) VALUES ('Коммуны');
INSERT INTO street (name) VALUES ('Косыгина');
INSERT INTO street (name) VALUES ('Лазо');
INSERT INTO street (name) VALUES ('Наставников');
INSERT INTO street (name) VALUES ('Осипенко');
INSERT INTO street (name) VALUES ('Отечественная');
INSERT INTO street (name) VALUES ('Передовиков');
INSERT INTO street (name) VALUES ('Ударников');
INSERT INTO street (name) VALUES ('Энтузиастов');

INSERT INTO address (STREET_ID, HOUSE, BUILDING) VALUES (4, 35, 1);
INSERT INTO address (STREET_ID, HOUSE, BUILDING) VALUES (1, 26, 1);
INSERT INTO address (STREET_ID, HOUSE, BUILDING) VALUES (14, 18, 1);
INSERT INTO address (STREET_ID, HOUSE, BUILDING) VALUES (13, 17, 1);
INSERT INTO address (STREET_ID, HOUSE, BUILDING) VALUES (13, 21, 1);
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (2, 17, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (3, 17, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 21, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (2, 21, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 23, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 25, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 27, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (1, 29, 'Ириновский');
# INSERT INTO address (BUILDING, HOUSE, STREET) VALUES (48, 31, 'Ириновский');
#
# INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('нет данных', 1, 2);
# INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль на связке', 2, 2);
# INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль на связке', 1, 3);
# INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль на связке', 2, 3);
# INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль от 1 и 3 пар', 1, 5);
# INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('аварийка энтузиастов', 2, 5);
# INSERT INTO entrance (ACCESS, NUMBER, ADDRESS_ID) VALUES ('дубль от 1 и 3 пар', 3, 5);
#
# INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Ключ не проверил', 2);
# INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Провери 20.11.17, подходит', 2);
# INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Здесь был я (админ)', 5);
# INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('никому не интересно', 5);
# INSERT INTO comment (MESSAGE, ENTRANCE_ID) VALUES ('Забаню!!!', 5);