ALTER TABLE public.capteur ADD COLUMN date_capteur date;

UPDATE public.capteur SET date_capteur=NOW();
