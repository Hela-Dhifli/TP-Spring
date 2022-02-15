CREATE TABLE team
(
    id IDENTITY NOT NULL PRIMARY KEY,
    name   VARCHAR(200),
    slogan VARCHAR(500)
);


CREATE TABLE player (
                        id IDENTITY NOT NULL PRIMARY KEY,
                        name varchar(200) NOT NULL,
                        number varchar(2) DEFAULT NULL,
                        position varchar(100) DEFAULT NULL,
                        team_id bigint(20) NOT NULL,
                        CONSTRAINT player_ibfk_1 FOREIGN KEY (team_id) REFERENCES team (id)
);