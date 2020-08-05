-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-07-28 18:53:09 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g

CREATE TABLE actividadmejora (
    id_actividadmejora           INTEGER NOT NULL,
    nombre                      NVARCHAR2(50),
    fechainicio                 DATE,
    fechatermino                DATE,
    estado                      NVARCHAR2(50),
    detalle                     NVARCHAR2(50),
    profesional_id_profesional  INTEGER NOT NULL,
    cliente_id_cliente          INTEGER NOT NULL
);

ALTER TABLE actividadmejora ADD CONSTRAINT actividadmejora_pk PRIMARY KEY ( id_actividadmejora );

CREATE TABLE administrador (
    id_administrador    INTEGER NOT NULL,
    nombre              NVARCHAR2(50),
    usuario_id_usuario  INTEGER NOT NULL,
    usuario_nickname    NVARCHAR2(50) NOT NULL
);

ALTER TABLE administrador ADD CONSTRAINT administrador_pk PRIMARY KEY ( id_administrador );

CREATE TABLE asesoria (
    id_asesoria                 INTEGER NOT NULL,
    fechayhora                  DATE,
    motivo                      NVARCHAR2(50),
    detalle                     NVARCHAR2(100),
    profesional_id_profesional  INTEGER NOT NULL,
    cliente_id_cliente          INTEGER NOT NULL
);

ALTER TABLE asesoria ADD CONSTRAINT asesoria_pk PRIMARY KEY ( id_asesoria );

CREATE TABLE asesoriaextra (
    id_asesoriaextra    INTEGER NOT NULL,
    fechayhora          DATE,
    motivo              NVARCHAR2(50),
    detalle             NVARCHAR2(100),
    profesional_id_profesional  INTEGER NOT NULL,
    cliente_id_cliente  INTEGER NOT NULL
);

ALTER TABLE asesoriaextra ADD CONSTRAINT asesoriaextra_pk PRIMARY KEY ( id_asesoriaextra );

CREATE TABLE capacitacion (
    id_capacitacion             INTEGER NOT NULL,
    fechayhora                  DATE,
    tema                        NVARCHAR2(50),
    contenido                   NVARCHAR2(100),
    profesional_id_profesional  INTEGER NOT NULL,
    cliente_id_cliente          INTEGER NOT NULL
);

ALTER TABLE capacitacion ADD CONSTRAINT capacitacion_pk PRIMARY KEY ( id_capacitacion );

CREATE TABLE checklist (
    id_checklist                INTEGER NOT NULL,
    version                     NVARCHAR2(50),
    visita_id_visita            INTEGER NOT NULL
);

ALTER TABLE checklist ADD CONSTRAINT checklist_pk PRIMARY KEY ( id_checklist );

CREATE TABLE cliente (
    id_cliente          INTEGER NOT NULL,
    nombreempresa       NVARCHAR2(50),
    rutempresa          NVARCHAR2(50),
    fecharegistro       DATE,
    usuario_id_usuario  INTEGER NOT NULL,
    usuario_nickname    NVARCHAR2(50) NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id_cliente );

CREATE TABLE detallechecklist (
    id_detallechecklist     INTEGER NOT NULL,
    descripcion             NVARCHAR2(100),
    estado                  NVARCHAR2(50),
    checklist_id_checklist  INTEGER NOT NULL
);

ALTER TABLE detallechecklist ADD CONSTRAINT detallechecklist_pk PRIMARY KEY ( id_detallechecklist );

CREATE TABLE detallefactura (
    id_detallefactura   INTEGER NOT NULL,
    nombre              NVARCHAR2(50),
    precio              NUMBER(38),
    cantidad            NUMBER(38),
    factura_id_factura  INTEGER NOT NULL
);

ALTER TABLE detallefactura ADD CONSTRAINT detallefactura_pk PRIMARY KEY ( id_detallefactura );

CREATE TABLE factura (
    id_factura          INTEGER NOT NULL,
    fechacobro          DATE,
    fechavencimiento    DATE,
    extras              NUMBER(38),
    impuestos           NUMBER(38),
    subtotal            NUMBER(38),
    total               NUMBER(38),
    cliente_id_cliente  INTEGER NOT NULL
);

ALTER TABLE factura ADD CONSTRAINT factura_pk PRIMARY KEY ( id_factura );

CREATE TABLE profesional (
    id_profesional      INTEGER NOT NULL,
    nombre              NVARCHAR2(50),
    apellido            NVARCHAR2(50),
    correo              NVARCHAR2(50),
    telefono            INTEGER,
    cargo               NVARCHAR2(50),
    usuario_id_usuario  INTEGER NOT NULL,
    usuario_nickname    NVARCHAR2(50) NOT NULL
);

ALTER TABLE profesional ADD CONSTRAINT profesional_pk PRIMARY KEY ( id_profesional );

CREATE TABLE reporteaccidente (
    id_reporteaccidente  INTEGER NOT NULL,
    fecha                DATE,
    direccion            NVARCHAR2(50),
    labor                NVARCHAR2(100),
    descripcion          NVARCHAR2(100),
    profesional_id_profesional  INTEGER NOT NULL,
    cliente_id_cliente   INTEGER NOT NULL
);

ALTER TABLE reporteaccidente ADD CONSTRAINT reporteaccidente_pk PRIMARY KEY ( id_reporteaccidente );

CREATE TABLE reportecliente (
    id_reportecliente           INTEGER NOT NULL,
    periodo                     DATE,
    indiceaccidentabilidad      INTEGER,
    morosidad                   CHAR(1),
    cliente_id_cliente          INTEGER NOT NULL,
    profesional_id_profesional  INTEGER NOT NULL
);

ALTER TABLE reportecliente ADD CONSTRAINT reportecliente_pk PRIMARY KEY ( id_reportecliente );

CREATE TABLE reporteglobal (
    id_reporteglobal            INTEGER NOT NULL,
    periodo                     DATE,
    cantidadcapacitacion        INTEGER,
    cantidadasesorias           INTEGER,
    cantidadactividades         INTEGER,
    profesional_id_profesional  INTEGER NOT NULL,
    cliente_id_cliente          INTEGER NOT NULL
);

ALTER TABLE reporteglobal ADD CONSTRAINT reporteglobal_pk PRIMARY KEY ( id_reporteglobal );

CREATE TABLE usuario (
    id_usuario INTEGER NOT NULL,
    nickname  NVARCHAR2(50) NOT NULL,
    password  NVARCHAR2(100),
    rol       NVARCHAR2(50)
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( nickname, id_usuario );

CREATE TABLE visita (
    id_visita                   INTEGER NOT NULL,
    fechavisita                 DATE,
    numerovisita                INTEGER NOT NULL,
    profesional_id_profesional  INTEGER NOT NULL,
    cliente_id_cliente          INTEGER NOT NULL
);

ALTER TABLE visita ADD CONSTRAINT visita_pk PRIMARY KEY ( id_visita );

ALTER TABLE actividadmejora
    ADD CONSTRAINT actividadmejora_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE actividadmejora
    ADD CONSTRAINT actividadmejora_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

ALTER TABLE administrador
    ADD CONSTRAINT administrador_usuario_fk FOREIGN KEY ( usuario_nickname, usuario_id_usuario )
        REFERENCES usuario ( nickname, id_usuario );

ALTER TABLE asesoria
    ADD CONSTRAINT asesoria_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE asesoria
    ADD CONSTRAINT asesoria_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

ALTER TABLE asesoriaextra
    ADD CONSTRAINT asesoriaextra_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );
        
ALTER TABLE asesoriaextra
    ADD CONSTRAINT asesoriaextra_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

ALTER TABLE capacitacion
    ADD CONSTRAINT capacitacion_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE capacitacion
    ADD CONSTRAINT capacitacion_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

ALTER TABLE checklist
    ADD CONSTRAINT checklist_visita_fk FOREIGN KEY ( visita_id_visita )
        REFERENCES visita ( id_visita );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_usuario_fk FOREIGN KEY ( usuario_nickname, usuario_id_usuario )
        REFERENCES usuario ( nickname, id_usuario );

ALTER TABLE detallechecklist
    ADD CONSTRAINT detallechecklist_checklist_fk FOREIGN KEY ( checklist_id_checklist )
        REFERENCES checklist ( id_checklist );

ALTER TABLE detallefactura
    ADD CONSTRAINT detallefactura_factura_fk FOREIGN KEY ( factura_id_factura )
        REFERENCES factura ( id_factura );

ALTER TABLE factura
    ADD CONSTRAINT factura_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE profesional
    ADD CONSTRAINT profesional_usuario_fk FOREIGN KEY ( usuario_nickname, usuario_id_usuario )
        REFERENCES usuario ( nickname, id_usuario );

ALTER TABLE reporteaccidente
    ADD CONSTRAINT reporteaccidente_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );
        
ALTER TABLE reporteaccidente
    ADD CONSTRAINT reportaccidente_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

ALTER TABLE reportecliente
    ADD CONSTRAINT reportecliente_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE reportecliente
    ADD CONSTRAINT reportecliente_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

ALTER TABLE reporteglobal
    ADD CONSTRAINT reporteglobal_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE reporteglobal
    ADD CONSTRAINT reporteglobal_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

ALTER TABLE visita
    ADD CONSTRAINT visita_cliente_fk FOREIGN KEY ( cliente_id_cliente )
        REFERENCES cliente ( id_cliente );

ALTER TABLE visita
    ADD CONSTRAINT visita_profesional_fk FOREIGN KEY ( profesional_id_profesional )
        REFERENCES profesional ( id_profesional );

CREATE SEQUENCE id_actividadmejora_seq START WITH 1;
CREATE TRIGGER id_actividadmejora_bi BEFORE INSERT ON actividadmejora FOR EACH ROW BEGIN SELECT id_actividadmejora_seq.nextval INTO :new.id_actividadmejora FROM dual; END;
/
CREATE SEQUENCE id_administrador_seq START WITH 1;
CREATE TRIGGER id_administrador_bi BEFORE INSERT ON administrador FOR EACH ROW BEGIN SELECT id_administrador_seq.nextval INTO :new.id_administrador FROM dual; END;
/
CREATE SEQUENCE id_asesoria_seq START WITH 1;
CREATE TRIGGER id_asesoria_bi BEFORE INSERT ON asesoria FOR EACH ROW BEGIN SELECT id_asesoria_seq.nextval INTO :new.id_asesoria FROM dual; END;
/
CREATE SEQUENCE id_asesoriaextra_seq START WITH 1;
CREATE TRIGGER id_asesoriaextra_bi BEFORE INSERT ON asesoriaextra FOR EACH ROW BEGIN SELECT id_asesoriaextra_seq.nextval INTO :new.id_asesoriaextra FROM dual; END;
/
CREATE SEQUENCE  id_capacitacion_seq START WITH 1;
CREATE TRIGGER  id_capacitacion_bi BEFORE INSERT ON capacitacion FOR EACH ROW BEGIN SELECT  id_capacitacion_seq.nextval INTO :new.id_capacitacion FROM dual; END;
/
CREATE SEQUENCE  id_checklist_seq START WITH 1;
CREATE TRIGGER  id_checklist_bi BEFORE INSERT ON checklist FOR EACH ROW BEGIN SELECT  id_checklist_seq.nextval INTO :new.id_checklist FROM dual; END;
/
CREATE SEQUENCE  id_cliente_seq START WITH 1;
CREATE TRIGGER  id_cliente_bi BEFORE INSERT ON cliente FOR EACH ROW BEGIN SELECT  id_cliente_seq.nextval INTO :new.id_cliente FROM dual; END;
/
CREATE SEQUENCE  id_detallechecklist_seq START WITH 1;
CREATE TRIGGER  id_detallechecklist_bi BEFORE INSERT ON detallechecklist FOR EACH ROW BEGIN SELECT  id_detallechecklist_seq.nextval INTO :new.id_detallechecklist FROM dual; END;
/
CREATE SEQUENCE  id_detallefactura_seq START WITH 1;
CREATE TRIGGER  id_detallefactura_bi BEFORE INSERT ON detallefactura FOR EACH ROW BEGIN SELECT  id_detallefactura_seq.nextval INTO :new.id_detallefactura FROM dual; END;
/
CREATE SEQUENCE  id_factura_seq START WITH 1;
CREATE TRIGGER  id_factura_bi BEFORE INSERT ON factura FOR EACH ROW BEGIN SELECT  id_factura_seq.nextval INTO :new.id_factura FROM dual; END;
/
CREATE SEQUENCE  id_profesional_seq START WITH 1;
CREATE TRIGGER  id_profesional_bi BEFORE INSERT ON profesional FOR EACH ROW BEGIN SELECT  id_profesional_seq.nextval INTO :new.id_profesional FROM dual; END;
/
CREATE SEQUENCE  id_reporteaccidente_seq START WITH 1;
CREATE TRIGGER  id_reporteaccidente_bi BEFORE INSERT ON reporteaccidente FOR EACH ROW BEGIN SELECT  id_reporteaccidente_seq.nextval INTO :new.id_reporteaccidente FROM dual; END;
/
CREATE SEQUENCE  id_reportecliente_seq START WITH 1;
CREATE TRIGGER  id_reportecliente_bi BEFORE INSERT ON reportecliente FOR EACH ROW BEGIN SELECT  id_reportecliente_seq.nextval INTO :new.id_reportecliente FROM dual; END;
/
CREATE SEQUENCE id_reporteglobal_seq START WITH 1;
CREATE TRIGGER  id_reporteglobal_bi BEFORE INSERT ON reporteglobal  FOR EACH ROW BEGIN SELECT  id_reporteglobal_seq.nextval INTO :new.id_reporteglobal  FROM dual; END;
/
CREATE SEQUENCE id_visita_seq START WITH 1;
CREATE TRIGGER  id_visita_bi BEFORE INSERT ON visita   FOR EACH ROW BEGIN SELECT  id_visita_seq.nextval INTO :new.id_visita   FROM dual; END;
/
CREATE SEQUENCE id_usuario_seq START WITH 1;
CREATE TRIGGER  id_usuario_bi BEFORE INSERT ON usuario   FOR EACH ROW BEGIN SELECT  id_usuario_seq.nextval INTO :new.id_usuario   FROM dual; END;
/
