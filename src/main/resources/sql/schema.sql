create schema if not exists matrix_cinema collate utf8mb4_0900_ai_ci;

use matrix_cinema;

create table if not exists hall
(
    id int null,
    name char(30) not null,
    row int(10) not null,
    seat int(10) not null
);

INSERT INTO matrix_cinema.hall (id, name, row, seat) VALUES (4, 'newHall',3,4);
