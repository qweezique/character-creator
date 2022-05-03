-- Database export via SQLPro (https://www.sqlprostudio.com/allapps.html)
-- Exported by qweezique at 04-05-2022 00:27.
-- WARNING: This file may contain descructive statements such as DROPs.
-- Please ensure that you are running the script at the proper location.


-- BEGIN TABLE public.character
DROP TABLE IF EXISTS public."character" CASCADE;
BEGIN;

CREATE TABLE IF NOT EXISTS public."character" (
	character_id integer NOT NULL,
	dexterity integer,
	energy integer,
	strength integer,
	vitality integer,
	guilded boolean,
	"level" integer,
	name character varying(255) NOT NULL,
	registration_date date,
	"type" character varying(255),
	guild_id integer,
	PRIMARY KEY(character_id)
);

COMMIT;

-- Inserting 7 rows into public."character"
-- Insert batch #1
INSERT INTO public."character" (character_id, dexterity, energy, strength, vitality, guilded, "level", name, registration_date, "type", guild_id) VALUES
(4, 140, 560, 100, 160, 'False', 3, 'Qwee', '2022-05-04', 'WIZZARD', NULL),
(5, 560, 2240, 400, 640, 'True', 5, 'Sorc', '2022-05-04', 'WIZZARD', 1),
(6, 70, 280, 50, 80, 'True', 2, 'Magical', '2022-05-04', 'WIZZARD', 1),
(9, 230, 60, 90, 80, 'True', 2, 'Assassin', '2022-05-04', 'THIEF', 3),
(10, 3680, 960, 1440, 1280, 'True', 6, 'Creed', '2022-05-04', 'THIEF', 3),
(8, 220, 100, 500, 160, 'True', 3, 'Fighter', '2022-05-04', 'KNIGHT', 2),
(7, 7040, 3200, 16000, 5120, 'False', 8, 'Paladin', '2022-05-04', 'KNIGHT', NULL);

-- END TABLE public.character

-- BEGIN TABLE public.guild
DROP TABLE IF EXISTS public.guild CASCADE;
BEGIN;

CREATE TABLE IF NOT EXISTS public.guild (
	guild_id integer NOT NULL,
	description character varying(255),
	message character varying(255),
	name character varying(255),
	PRIMARY KEY(guild_id)
);

COMMIT;

-- Inserting 3 rows into public.guild
-- Insert batch #1
INSERT INTO public.guild (guild_id, description, message, name) VALUES
(1, 'Волшебнкии обладают высоким интеллектом, но слабы в ближних боях', 'На сервере особый ивент: повышен дроп вещей для волшебников', 'WIZZARD'),
(2, 'Зачем нужен интеллект, если есть сила о отвага?', 'Все собираемся в городе для обсуждения стратегии', 'KNIGHT'),
(3, 'Хочешь жить - умей вертеться; у воров повышенная ловкость', 'Все на поиске редкого артефакта!', 'THIEF');

-- END TABLE public.guild

ALTER TABLE IF EXISTS public."character"
	ADD CONSTRAINT fkbun3ftlhd0wdldrvv38m8w3ky
	FOREIGN KEY (guild_id)
	REFERENCES public.guild (guild_id);

