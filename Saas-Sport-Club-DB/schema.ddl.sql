/*
 * DDL = Data Definition Language
 * Command lines from 'Saas-Sport-Club-DB' folder:
 * psql -h localhost -p 5432 -U postgres -d nandaparbat
 * \i schema.ddl.sql
 * \q
 */

DROP TABLE IF EXISTS roles CASCADE ;
DROP TABLE IF EXISTS players CASCADE ;
DROP TABLE IF EXISTS formats CASCADE ;
DROP TABLE IF EXISTS pairing_styles CASCADE ;
DROP TABLE IF EXISTS tournaments CASCADE ;
DROP TABLE IF EXISTS teams CASCADE ;
DROP TABLE IF EXISTS teams_players CASCADE ;
DROP TABLE IF EXISTS tournaments_players CASCADE ;


-- ON DELETE CASCADE

CREATE TABLE roles (
    id SERIAL PRIMARY KEY UNIQUE,
    role_name VARCHAR(20) UNIQUE NOT NULL
);
-- table created

CREATE TABLE players (
    id SERIAL PRIMARY KEY UNIQUE,
    first_name VARCHAR(100),
    last_name VARCHAR(255),
    fide_number INTEGER UNIQUE NOT NULL,
    elo INTEGER DEFAULT 1199,
    password VARCHAR(60) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    role_id INTEGER,
         CONSTRAINT fk_role_id
             FOREIGN KEY (role_id)
                  REFERENCES roles(id) ON DELETE SET NULL
);
-- table created


CREATE TABLE formats (
 id SERIAL PRIMARY KEY UNIQUE,
 format_name VARCHAR(10) UNIQUE NOT NULL
);
-- table created

CREATE TABLE pairing_styles (
id SERIAL PRIMARY KEY UNIQUE,
pairing_style VARCHAR(50) UNIQUE NOT NULL
);
-- table created

-- ALL tournaments will be false until an administrator says otherwise and
-- modify it
CREATE TABLE tournaments (
    id SERIAL PRIMARY KEY UNIQUE,
    tournament_name VARCHAR(255) UNIQUE NOT NULL,
    is_event BOOLEAN DEFAULT FALSE,
    date_of_start DATE NOT NULL,
    date_of_end DATE,
    number_of_rounds SMALLINT NOT NULL,
    format INTEGER,
    pairing_style INTEGER,
    organisator VARCHAR(100) NOT NULL,
    contact VARCHAR(255) NOT NULL,
    capacity INTEGER ,
    first_price INTEGER DEFAULT 0,
    second_price INTEGER DEFAULT 0,
    third_price INTEGER DEFAULT 0,
    register_fee_senior SMALLINT DEFAULT 0,
    register_fee_junior SMALLINT DEFAULT 0,
    description VARCHAR(255) NOT NULL,
    CONSTRAINT fk_format_name
        FOREIGN KEY (format)
            REFERENCES formats(id) ON DELETE SET NULL,
    CONSTRAINT fk_pairing_style
        FOREIGN KEY (pairing_style)
            REFERENCES pairing_styles(id) ON DELETE SET NULL
);
-- table created

CREATE INDEX idx_tour_name ON tournaments(tournament_name);

--* creating index for highly requested column;

CREATE TABLE teams (
    id SERIAL PRIMARY KEY,
    team_name VARCHAR(50) UNIQUE NOT NULL
);
-- table created


CREATE TABLE teams_players (
team_id INTEGER,
player_id INTEGER,
PRIMARY KEY (team_id, player_id),
CONSTRAINT fk_team_id
   FOREIGN KEY(team_id)
       REFERENCES teams(id) ON DELETE CASCADE,
CONSTRAINT fk_player_id
   FOREIGN KEY (player_id)
       REFERENCES players(id) ON DELETE CASCADE
);

CREATE TABLE tournaments_players (
    tournament_id INTEGER,
    player_id INTEGER,
    PRIMARY KEY (tournament_id, player_id),
    CONSTRAINT fk_tournament_id
        FOREIGN KEY(tournament_id)
            REFERENCES tournaments(id) ON DELETE CASCADE ,
    CONSTRAINT fk_player_id
        FOREIGN KEY (player_id)
            REFERENCES players(id) ON DELETE CASCADE
);

-- CREATE TABLE players_teams (
--     player_id INTEGER,
--     team_id INTEGER,
--     PRIMARY KEY (player_id, team_id),
--     CONSTRAINT fk_player_id
--         FOREIGN KEY(player_id)
--             REFERENCES players(id),
--     CONSTRAINT fk_team_id
--         FOREIGN KEY(team_id)
--                 REFERENCES teams(id)
-- );
--
-- CREATE TABLE players_tournaments (
--     player_id INTEGER,
--     tournament_id INTEGER,
--     PRIMARY KEY (player_id, tournament_id),
--     CONSTRAINT fk_player_id
--         FOREIGN KEY(player_id)
--             REFERENCES players(id),
--     CONSTRAINT fk_tournament_id
--         FOREIGN KEY(tournament_id)
--             REFERENCES tournaments(id)
--
-- );



