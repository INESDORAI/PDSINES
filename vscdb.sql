CREATE TABLE public.personne(
  id integer NOT NULL,
  name character varying,
  age integer,
  CONSTRAINT personne_pkey PRIMARY KEY (id)
)WITH (OIDS=FALSE);
ALTER TABLE public.personne OWNER TO postgres;

CREATE TABLE public.enterprise(
  id serial NOT NULL,
  code character varying(255),
  lib character varying(255),
  adresse character varying,
  code_postal character varying,
  pays character varying,  
  CONSTRAINT enterprise_pk PRIMARY KEY (id)
)WITH (OIDS=FALSE);
ALTER TABLE public.enterprise OWNER TO postgres;

CREATE TABLE public.local(
  id serial NOT NULL,
  lib character varying NOT NULL,
  batiment character varying NOT NULL,
  etage character varying NOT NULL,
  numero character varying NOT NULL,
  id_enterprise integer NOT NULL,
  nbre_place integer,
  nbre_place_occupe integer,
  CONSTRAINT local_pk PRIMARY KEY (id),
  CONSTRAINT local_enterprise_fk FOREIGN KEY (id_enterprise)
      REFERENCES public.enterprise (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      NOT VALID
)WITH (OIDS=FALSE);
ALTER TABLE public.local OWNER TO postgres;

CREATE TABLE public.capteur(
  id serial NOT NULL,
  code character varying(255),
  type_capteur character varying(255),
  valeur_capteur double precision,
  id_local integer NOT NULL,  
  CONSTRAINT capteur_pk PRIMARY KEY (id),
  CONSTRAINT capteur_local_fk FOREIGN KEY (id_local)
      REFERENCES public.local (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      NOT VALID
)WITH (OIDS=FALSE);
ALTER TABLE public.capteur OWNER TO postgres;

CREATE TABLE public.materiel(
  id serial NOT NULL,
  code character varying(255),
  type_materiel character varying(255),
  consommation double precision,
  unite_consommation character varying(10),
  lib character varying(255),
  id_local integer NOT NULL,  
  CONSTRAINT materiel_pk PRIMARY KEY (id),
  CONSTRAINT materiel_lacal_fk FOREIGN KEY (id_local)
      REFERENCES public.local (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      NOT VALID
)WITH (OIDS=FALSE);
ALTER TABLE public.materiel OWNER TO postgres;

CREATE TABLE public.mobilier(
  id serial NOT NULL,
  code character varying(255),
  type_mobilier character varying(255),
  lib character varying(255),
  id_local integer NOT NULL,
  CONSTRAINT mobilier_pk PRIMARY KEY (id),
  CONSTRAINT mobilier_local_fk FOREIGN KEY (id_local)
      REFERENCES public.local (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)WITH (OIDS=FALSE);
ALTER TABLE public.mobilier OWNER TO postgres;

