

DROP TABLE IF EXISTS T_PADRE ;
DROP TABLE IF EXISTS T_HIJA ;


CREATE TABLE T_PADRE (
	ID_T_PADRE INTEGER ,
	DESCRIPCION VARCHAR(20),
	ESTATUS INTEGER
);

CREATE TABLE T_HIJA (
	ID_T_HIJA INTEGER ,
	DESCRIPCION VARCHAR(20),
	ID_T_PADRE INTEGER,
	ESTATUS INTEGER,
	FOREIGN KEY(ID_T_PADRE) REFERENCES T_PADRE(ID_T_PADRE)
);

INSERT INTO T_PADRE (ID_T_PADRE, DESCRIPCION, ESTATUS) VALUES (1, 'PADRE 1', 0);

INSERT INTO T_HIJA (ID_T_HIJA, DESCRIPCION, ID_T_PADRE, ESTATUS) VALUES (1, 'PADRE 1 HIJA 1', 1, 0);
INSERT INTO T_HIJA (ID_T_HIJA, DESCRIPCION, ID_T_PADRE, ESTATUS) VALUES (2, 'PADRE 1 HIJA 2', 1, 0);
INSERT INTO T_HIJA (ID_T_HIJA, DESCRIPCION, ID_T_PADRE, ESTATUS) VALUES (3, 'PADRE 1 HIJA 3', 1, 0);


INSERT INTO T_PADRE (ID_T_PADRE, DESCRIPCION, ESTATUS) VALUES (2, 'PADRE 2', 0);

INSERT INTO T_HIJA (ID_T_HIJA, DESCRIPCION, ID_T_PADRE, ESTATUS) VALUES (4, 'PADRE 2 HIJA 1', 2, 0);
INSERT INTO T_HIJA (ID_T_HIJA, DESCRIPCION, ID_T_PADRE, ESTATUS) VALUES (5, 'PADRE 2 HIJA 2', 2, 0);
INSERT INTO T_HIJA (ID_T_HIJA, DESCRIPCION, ID_T_PADRE, ESTATUS) VALUES (6, 'PADRE 2 HIJA 3', 2, 0);










