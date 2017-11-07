DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS entrance;
DROP TABLE IF EXISTS address;

CREATE TABLE address (
  ID INT NOT NULL AUTO_INCREMENT ,
  STREET VARCHAR(30) NOT NULL ,
  HOUSE INT NOT NULL ,
  BUILDING INT NOT NULL ,
  VERSION INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (ID)
);

CREATE TABLE entrance (
  ID INT NOT NULL AUTO_INCREMENT ,
  ADDRESS_ID INT NOT NULL ,
  NUMBER INT NOT NULL ,
  ACCESS VARCHAR(255) ,
  VERSION INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (ID) ,
  CONSTRAINT FK_ENTRANCE_1 FOREIGN KEY (ADDRESS_ID) REFERENCES address (ID)
);

CREATE TABLE comment (
  ID INT NOT NULL  AUTO_INCREMENT ,
  MESSAGE VARCHAR(255) NOT NULL ,
  VERSION INT NOT NULL DEFAULT 0 ,
  ENTRANCE_ID INT NOT NULL ,
  PRIMARY KEY (ID) ,
  CONSTRAINT FK_COMMENT_1 FOREIGN KEY (ENTRANCE_ID) REFERENCES entrance (ID)
);