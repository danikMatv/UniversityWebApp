CREATE TABLE Users
(
    userId SERIAL NOT NULL ,
    userName varchar(256) NOT NULL ,
    email varchar(256) NOT NULL ,
    password varchar(256) NOT NULL,
    userRole varchar(256) NOT NULL
);