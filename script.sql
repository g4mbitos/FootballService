CREATE DATABASE footballdb;

\c footballdb;

CREATE TABLE public.players
(
    id bigint NOT NULL DEFAULT nextval('players_id_seq'::regclass),
    birthday timestamp without time zone,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    "position" integer,
    team_id bigint,
    CONSTRAINT players_pkey PRIMARY KEY (id),
    CONSTRAINT fk5nglidr00c4dyybl171v6kask FOREIGN KEY (team_id)
        REFERENCES public.teams (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.players
    OWNER to postgres;


CREATE TABLE public.teams
(
    id bigint NOT NULL DEFAULT nextval('teams_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    cap_id bigint,
    CONSTRAINT teams_pkey PRIMARY KEY (id),
    CONSTRAINT fk69lju5qh612uje1ijaej7u10r FOREIGN KEY (cap_id)
        REFERENCES public.players (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.teams
    OWNER to postgres;