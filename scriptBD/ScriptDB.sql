-- Crear la base de datos
CREATE DATABASE evaluatorDB;

-- Conectar a la base de datos recién creada
\c evaluatorDB;

DROP SEQUENCE IF EXISTS estudiante_id_estudiante_seq;

CREATE SEQUENCE IF NOT EXISTS estudiante_id_estudiante_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY estudiante.id_estudiante;
ALTER SEQUENCE estudiante_id_estudiante_seq OWNER TO postgres;

DROP SEQUENCE IF EXISTS examen_id_examen_seq;

CREATE SEQUENCE IF NOT EXISTS examen_id_examen_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY examen.id_examen;
ALTER SEQUENCE examen_id_examen_seq OWNER TO postgres;

DROP SEQUENCE IF EXISTS pregunta_id_pregunta_seq;

CREATE SEQUENCE IF NOT EXISTS pregunta_id_pregunta_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY pregunta.id_pregunta;
ALTER SEQUENCE pregunta_id_pregunta_seq OWNER TO postgres;

DROP SEQUENCE IF EXISTS respuesta_id_respuesta_seq;

CREATE SEQUENCE IF NOT EXISTS respuesta_id_respuesta_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY respuesta.id_respuesta;
ALTER SEQUENCE respuesta_id_respuesta_seq OWNER TO postgres;

DROP SEQUENCE IF EXISTS time_zones_id_time_zone_seq;

CREATE SEQUENCE IF NOT EXISTS time_zones_id_time_zone_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY time_zones.id_time_zone;
ALTER SEQUENCE time_zones_id_time_zone_seq OWNER TO postgres;

DROP TABLE IF EXISTS estudiante;

CREATE TABLE IF NOT EXISTS estudiante
(
    edad_estudiante integer NOT NULL,
    id_estudiante bigint NOT NULL DEFAULT nextval('estudiante_id_estudiante_seq'::regclass),
    ciudad_estudiante character varying(255) COLLATE NOT NULL,
    nombre_estudiante character varying(255) COLLATE NOT NULL,
    time_zone_estudiante character varying(255) COLLATE NOT NULL,
    CONSTRAINT estudiante_pkey PRIMARY KEY (id_estudiante)
)

ALTER TABLE IF EXISTS estudiante OWNER to postgres;


DROP TABLE IF EXISTS examen;

CREATE TABLE IF NOT EXISTS examen
(
    fecha_presentacion date,
    id_estudiante bigint,
    id_examen bigint NOT NULL DEFAULT nextval('examen_id_examen_seq'::regclass),
    CONSTRAINT examen_pkey PRIMARY KEY (id_examen),
    CONSTRAINT estudiante_fkey FOREIGN KEY (id_estudiante)
        REFERENCES estudiante (id_estudiante)
)

ALTER TABLE IF EXISTS examen OWNER to postgres;


DROP TABLE IF EXISTS pregunta;

CREATE TABLE IF NOT EXISTS pregunta
(
    puntaje integer NOT NULL,
    id_examen bigint,
    id_pregunta bigint NOT NULL DEFAULT nextval('pregunta_id_pregunta_seq'::regclass),
    respuesta_ok character varying(255) COLLATE NOT NULL,
    respuestaa character varying(255) COLLATE NOT NULL,
    respuestab character varying(255) COLLATE NOT NULL,
    respuestac character varying(255) COLLATE NOT NULL,
    respuestad character varying(255) COLLATE NOT NULL,
    texto_pregunta character varying(255) COLLATE NOT NULL,
    CONSTRAINT pregunta_pkey PRIMARY KEY (id_pregunta),
    CONSTRAINT examen_fkey FOREIGN KEY (id_examen)
        REFERENCES examen (id_examen)
)

ALTER TABLE IF EXISTS pregunta OWNER to postgres;

