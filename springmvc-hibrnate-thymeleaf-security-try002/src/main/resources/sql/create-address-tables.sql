DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS entrance;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS street;

CREATE TABLE street (
  ID INT NOT NULL AUTO_INCREMENT ,
  NAME VARCHAR(30) NOT NULL ,
  PRIMARY KEY (ID, NAME)
);

CREATE TABLE address (
  ID INT NOT NULL AUTO_INCREMENT ,
  STREET_ID INT NOT NULL ,
  HOUSE INT NOT NULL ,
  BUILDING INT NOT NULL ,
  PRIMARY KEY (ID) ,
  CONSTRAINT FK_ADDRESS_1 FOREIGN KEY (STREET_ID) REFERENCES street (ID)
);

CREATE TABLE entrance (
  ID INT NOT NULL AUTO_INCREMENT ,
  ADDRESS_ID INT NOT NULL ,
  NUMBER INT NOT NULL ,
  KEY_NUMBER INT NOT NULL ,
  ACCESS VARCHAR(255) ,
  PRIMARY KEY (ID) ,
  CONSTRAINT FK_ENTRANCE_1 FOREIGN KEY (ADDRESS_ID) REFERENCES address (ID)
);

CREATE TABLE comment (
  ID INT NOT NULL  AUTO_INCREMENT ,
  MESSAGE VARCHAR(255) NOT NULL ,
  ENTRANCE_ID INT NOT NULL ,
  PRIMARY KEY (ID) ,
  CONSTRAINT FK_COMMENT_1 FOREIGN KEY (ENTRANCE_ID) REFERENCES entrance (ID)
);

