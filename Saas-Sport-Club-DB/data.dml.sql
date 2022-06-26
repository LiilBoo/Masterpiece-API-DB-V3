/*
 * DML = Data Manipulation Language
 * Command lines from 'Saas-Sport-CLub-DB' folder:
 * psql -h localhost -p 5432 -U postgres -d nandaparbat
 * \i data.dml.sql
 * \q
 */

 INSERT INTO roles (
     role_name
) VALUES
('ROLE_SUPER_ADMIN'),
('ROLE_ADMIN'),
('ROLE_ORGANISATOR')
;
-- semi-colon is here : end of roles insertion

INSERT INTO players (
    first_name,
    last_name,
    fide_number,
    elo,
    password,
    username,
    role_id
)
 VALUES
('Francis', 'B', 551001756, 1326, '$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi',  'F@duck.com',
(SELECT r.id FROM roles r WHERE r.role_name = 'ROLE_SUPER_ADMIN')),

('Selena', 'Gomez', 440990645, 2900, '$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi',
'Gomez@duck.com',
(SELECT r.id FROM roles r WHERE r.role_name = 'ROLE_SUPER_ADMIN')),

('Phillipe', 'V', 339889534, 1399, '$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi', 'V@duck.com',
(SELECT r.id FROM roles r WHERE r.role_name = 'ROLE_ORGANISATOR')),

('David', 'D', 228778423, 1399, '$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi', 'D@duck.com',
(SELECT r.id FROM roles r WHERE r.role_name = 'ROLE_ORGANISATOR')),

('Oscar', 'T', 117667312, 2900, '$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi', 'T@duck.com',
(SELECT r.id FROM roles r WHERE r.role_name = 'ROLE_ORGANISATOR')),

('Phillip', 'W', 008556201, 1700, '$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi','W@duck.com',
(SELECT r.id FROM roles r  WHERE r.role_name = 'ROLE_ORGANISATOR')),

('Harry', 'P', 1196673012, 2153, '$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi','H@duck.com',
(SELECT r.id FROM roles r  WHERE r.role_name = 'ROLE_ORGANISATOR')),

('Stephane', 'Swag',207784123, 2901,
'$2a$10$2UTWUnKf2Q1WDzvdau8.MuOLJAI0piHweE52tPuWYBUVeupqIY8Yi','P@duck.com',
(SELECT r.id FROM roles r  WHERE r.role_name = 'ROLE_ORGANISATOR'))
;
--   End of insertion for initial players
-- validated insert

INSERT INTO formats (
    format_name
)
VALUES
('blitz'),
('rapid'),
('fischer'),
('960'),
('joueuses')
;
-- end of insert

INSERT INTO pairing_styles ( pairing_style )
VALUES
('Suisse'),
       ('Random'),
        ('Closed'),
            ('Determined')
;
-- end of insert


INSERT INTO tournaments (
    tournament_name,
    is_event,
    date_of_start,
    date_of_end,
    number_of_rounds,
    format,
    pairing_style,
    organisator,
    contact,
    capacity,
    first_price,
    second_price,
    third_price,
    register_fee_junior,
    register_fee_senior,
    description
)
VALUES
(
 'Festival International d''Echecs de Clichy 2022',
 TRUE,
 '2022-07-03',
 '2022-07-03',
 9,
 (SELECT f.id FROM formats f WHERE f.format_name = 'rapid'),
 (SELECT p.id FROM pairing_styles p WHERE p.pairing_style =
                                                    'Suisse' ),
 'Isabelle',
 'Informations: https://clichyechecs.wixsite.com/accueil/copie-de-festival ' ||
 'Inscription: https://www.billetweb' ||
 '.fr/festival-international-dechecs-de-clichy-3-juillet-2022 Renseignements:' ||
 ' Isabelle isa@outlook.fr Gomez@duck.com',
 100,
 1000,
 NULL,
 NULL,
 20,
 30,
 'http://www.echecs.asso.fr/Tournois/Id/55346/55346.pdf'
 ),
(
'7eme Open International de Noisiel - Open A (plus de 1900)',
FALSE ,
'2022-07-09',
'2022-07-13',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'fischer'),
(SELECT p.id
FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'PINDRIN',
'Gomez@duck.com',
220,
1200,
800,
600,
62,
43,
'ELO-POSSIBILITE DE PRENDRE 2 BYES AUX 6 PREMIERES RONDES
POINTAGE LUNDI LE 09/07/2022 ENTRE 8H45 ET 9H30
 DISTRIBUTION DU PRIX A 15H'
),
       -- validated
(
'7eme Open International de Noisiel - Open B (entre 1400 et 2000)',
FALSE,
'2022-07-09',
'2022-07-13',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'fischer'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'PINDRIN',
'Gomez@duck.com',
220,
500,
350,
250,
44,
31,
 'ELO-POSSIBILITE DE PRENDRE 2 BYES AUX 6 PREMIERES RONDES
POINTAGE LUNDI LE 09/07/2022 ENTRE 8H45 ET 9H30
 DISTRIBUTION DU PRIX A 15H'
),
       -- validated insert
(
'7eme Open International de Noisiel - Open C (-1600)',
FALSE,
'2022-07-09',
'2022-07-13',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'fischer'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'PINDRIN',
'Gomez@duck.com',
220,
250,
150,
100,
36,
25,
' ELO-POSSIBILITE DE PRENDRE 2 BYES AUX 6 PREMIERES RONDES' ||
'
POINTAGE LUNDI LE 09/07/2022 ENTRE 8H45 ET 9H30
 DISTRIBUTION DU PRIX A 15H'
),
       -- validated insert
(
'Championnat de Paris IdF 2022',
TRUE,
'2022-07-12',
'2022-07-17',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'fischer'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Ligue IdF des Echecs',
'ligue@idf-echecs.com Site web: www.idf-echecs.com Gomez@duck.com',
NULL,
2500,
1200,
1000,
60,
40,
'Lieu: Halle Carpentier 81 boulevard Massena 75013 Paris - 1er prix: 1000 € - Insc.: 60 €/40 € (70 €/45 € après le 12/06 et 80€/50€ sur place)'
),
       -- validated insert
(
'Championnat de Paris IdF 2022 Open A',
TRUE,
'2022-07-12',
'2022-07-17',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'fischer'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Ligue IdF des Echecs',
'ligue@idf-echecs.com Site web: www.idf-echecs.com',
1000,
800,
500,
300,
60,
40,
'Lieu: Halle Carpentier 81 boulevard Massena 75013 - Insc.: 60 €/40 € (70 €/45 € après le 12/06 et 80€/50€ sur place)'
),
       -- validated insert
(
'Championnat de Paris IdF 2022 Open B',
TRUE,
'2022-07-12',
'2022-07-17',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'fischer'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Ligue IdF des Echecs',
'ligue@idf-echecs.com Site web: www.idf-echecs.com',
NULL,
500,
300,
200,
60,
40,
'Lieu: Halle Carpentier 81 boulevard Massena 75013 Insc.: 60 €/40 € (70 €/45 € après le 12/06 et 80€/50€ sur place)'
),
       -- validated insert
(
'Championnat de Paris IdF 2022 Open C',
TRUE,
'2022-07-12',
'2022-07-17',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'fischer'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Ligue IdF des Echecs',
'ligue@idf-echecs.com Site web: www.idf-echecs.com',
NULL,
250,
150,
100,
60,
40,
'Lieu: Halle Carpentier 81 boulevard Massena 75013 Insc.: 60 €/40 € (70 €/45 € après le 12/06 et 80€/50€ sur place)'
),
       -- validated insert
(
'407e Rapide Fide du Canal',
 FALSE,
 '2022-07-01',
 '2022-07-01',
 5,
(SELECT f.id FROM formats f WHERE f.format_name = 'rapid'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Atelier du Canal',
'toto 00 38 07 48 92 (sms uniquement) toto.tata@free.fr',
 NULL,
 NULL,
 NULL,
 NULL,
 6,
 6,
'à réserver par sms
5 rondes de 15 min + 3 s / coup
le tournoi démarre à 20 h !'
),
       -- validated insert
(
'7e Open rapide de Yerres Open A',
FALSE,
'2022-07-03',
'2022-07-03',
7,
(SELECT f.id FROM formats f WHERE f.format_name = 'rapid'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Atelier du Canal',
'toto 00 38 07 48 92 toto.tata@free.fr',
NULL,
150,
NULL,
NULL,
15,
7,
'1er Prix: 150 € garantis si 50 inscrits payants'
),
(
'Toto Grand Prix',
FALSE,
'2022-07-01',
'2022-07-01',
2,
(SELECT f.id FROM formats f WHERE f.format_name = 'rapid'),
(SELECT p.id
FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Toto High Council',
'toto 00 38 07 48 92 toto.tata@free.fr',
999,
-300,
-200,
-100,
20,
20,
'1ers Prix garantis si 50 inscrits payants'
),
(
'Toto Grand Prix - Tour A',
TRUE,
'2022-07-01',
'2022-07-01',
2,
(SELECT f.id FROM formats f WHERE f.format_name = 'rapid'),
(SELECT p.id
 FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'Toto High Council',
'toto 00 38 07 48 92 toto.tata@free.fr',
999,
-300,
-200,
-100,
20,
20,
'1ers Prix garantis si 50 inscrits payants'
),
(
'Blitz Mania',
FALSE ,
'2022-07-12',
'2022-07-17',
9,
(SELECT f.id FROM formats f WHERE f.format_name = 'blitz'),
(SELECT p.id
FROM pairing_styles p WHERE p.pairing_style = 'Suisse'),
'V chess club',
'B@duck.com',
1800,
500,
300,
200,
60,
40,
'Marijoa will ...'
)
;
-- validated insert
-- end of tournament inserts

INSERT INTO teams (
        team_name
)
VALUES
('Avengers'),('Suicid Squad'),('Dream Team'),('Army of the night'),('Mugiwara'),
('Baroque Works'),('Navy'),('CP9'),('Doflamingo Family'),('Beast Pirates'),
('MOM Pirates'),('Pirates of The Heart')
;

INSERT INTO teams_players VALUES

((SELECT t.id FROM teams t WHERE t.team_name = 'Avengers'),
(SELECT p.id FROM players p WHERE p.first_name = 'Oscar')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Avengers'),
(SELECT p.id FROM players p WHERE p.first_name = 'Phillip')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Avengers'),
(SELECT p.id FROM players p WHERE p.first_name = 'Francis')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Avengers'),
(SELECT p.id FROM players p WHERE p.first_name = 'Harry')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Suicid Squad'),
(SELECT p.id FROM players p WHERE p.first_name = 'Francis')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Dream Team'),
(SELECT p.id FROM players p WHERE p.first_name = 'Francis')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Mugiwara'),
(SELECT p.id FROM players p WHERE p.first_name = 'Francis')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Mugiwara'),
(SELECT p.id FROM players p WHERE p.first_name = 'Oscar')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Mugiwara'),
(SELECT p.id FROM players p WHERE p.first_name = 'Selena')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Dream Team'),
(SELECT p.id FROM players p WHERE p.first_name = 'Selena')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Suicid Squad'),
(SELECT p.id FROM players p WHERE p.first_name = 'Selena')),

((SELECT t.id FROM teams t WHERE t.team_name = 'Mugiwara'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Stephane'))
;

INSERT INTO tournaments_players VALUES

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Championnat de Paris IdF 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Oscar')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Championnat de Paris IdF 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Phillip')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Championnat de Paris IdF 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Francis')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Championnat de Paris IdF 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Harry')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Championnat de Paris IdF 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'David')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Championnat de Paris IdF 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Phillipe')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Championnat de Paris IdF 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Selena')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Festival International d''Echecs de Clichy 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Oscar')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Festival International d''Echecs de Clichy 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Phillip')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Festival International d''Echecs de Clichy 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Francis')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Festival International d''Echecs de Clichy 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Harry')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Festival International d''Echecs de Clichy 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'David')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Festival International d''Echecs de Clichy 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Phillipe')),

((SELECT t.id FROM tournaments t WHERE t.tournament_name = 'Festival International d''Echecs de Clichy 2022'),
 (SELECT p.id FROM players p WHERE p.first_name = 'Selena'))
;
-- end of tournaments_players
-- validated inserts