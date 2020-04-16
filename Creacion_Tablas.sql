DROP TABLE USUARIO_OBJETIVOS;
DROP TABLE OBJETIVOS;
DROP TABLE USUARIOS;

CREATE TABLE USUARIOS(
    username varchar2(50),
    email varchar2(50) not null,
    pass  varchar(30) not null,
    retypePass varchar(30) not null,
    age integer not null,
    height integer not null,
    weight integer not null,
    hip integer not null,
    waist integer not null,
    unique(email),
    PRIMARY KEY(username)
);

CREATE TABLE OBJETIVOS(
    objectiveName varchar(30),
    PRIMARY KEY(objectiveName)
);

CREATE TABLE USUARIO_OBJETIVOS(
    OID_US_OB integer not null,
    username varchar2(50),
    objectiveName varchar(30),
    PRIMARY KEY(OID_US_OB),
    FOREIGN KEY(username) REFERENCES USUARIOS on delete cascade ,
    FOREIGN KEY(objectiveName) REFERENCES OBJETIVOS on delete cascade
);