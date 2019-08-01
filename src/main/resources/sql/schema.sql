CREATE SCHEMA if not exists `matrix_cinema` ;
CREATE TABLE if not exists  `matrix_cinema`.`movie` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(45) NULL,
                                          `running` TINYINT NULL,
                                          PRIMARY KEY (`id`));
CREATE TABLE if not exists  `matrix_cinema`.`hall` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `name` VARCHAR(45) NULL,
                                         `row` INT NULL,
                                         `seat` INT NULL,
                                         PRIMARY KEY (`id`));
CREATE TABLE if not exists `matrix_cinema`.`schedule` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `movie_id` INT NULL,
                                            `hall_id` INT NULL,
                                            `date` DATETIME NULL,
                                            PRIMARY KEY (`id`),
                                            INDEX `movie_id_idx` (`movie_id` ASC) VISIBLE,
                                            INDEX `hall_id_idx` (`hall_id` ASC) VISIBLE,
                                            CONSTRAINT `movie_id_fk`
                                                FOREIGN KEY (`movie_id`)
                                                    REFERENCES `matrix_cinema`.`movie` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION,
                                            CONSTRAINT `hall_id_fk`
                                                FOREIGN KEY (`hall_id`)
                                                    REFERENCES `matrix_cinema`.`hall` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION);

CREATE TABLE if not exists `matrix_cinema`.`reservation` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `row_number` INT NULL,
                                               `seat_number` INT NULL,
                                               `schedule_id` INT NULL,
                                               `code` VARCHAR(45) NULL,
                                               PRIMARY KEY (`id`),
                                               INDEX `schedule_res_id_idx` (`schedule_id` ASC) VISIBLE,
                                               CONSTRAINT `schedule_res_id`
                                                   FOREIGN KEY (`schedule_id`)
                                                       REFERENCES `matrix_cinema`.`schedule` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION);

INSERT INTO `matrix_cinema`.`movie` (`id`, `name`, `running`) VALUES ('1', 'Lion King', '1');
INSERT INTO `matrix_cinema`.`movie` (`id`, `name`, `running`) VALUES ('2', 'IT', '0');
INSERT INTO `matrix_cinema`.`movie` (`id`, `name`, `running`) VALUES ('3', 'Avengers', '1');
INSERT INTO `matrix_cinema`.`movie` (`id`, `name`, `running`) VALUES ('4', 'Anna', '1');

INSERT INTO `matrix_cinema`.`hall` (`id`, `name`, `row`, `seat`) VALUES ('1', 'Trinity', '5', '5');
INSERT INTO `matrix_cinema`.`hall` (`id`, `name`, `row`, `seat`) VALUES ('2', 'Neo', '8', '6');
INSERT INTO `matrix_cinema`.`hall` (`id`, `name`, `row`, `seat`) VALUES ('3', 'Morpheus', '6', '6');

INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('1', '1', '2', '2019-07-20 15:00:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('2', '1', '1', '2019-07-21 18:30:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('3', '1', '2', '2019-07-22 21:30:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('4', '3', '3', '2019-07-20 23:00:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('5', '3', '1', '2019-07-22 19:00:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('6', '3', '1', '2019-07-21 21:30:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('7', '4', '3', '2019-07-22 20:30:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('8', '4', '1', '2019-07-20 23:30:00');
INSERT INTO `matrix_cinema`.`schedule` (`id`, `movie_id`, `hall_id`, `date`) VALUES ('9', '4', '2', '2019-07-21 19:30:00');

INSERT INTO `matrix_cinema`.`reservation` (`id`, `row_number`, `seat_number`, `schedule_id`) VALUES ('1', '2', '3', '2');
INSERT INTO `matrix_cinema`.`reservation` (`id`, `row_number`, `seat_number`,  `schedule_id`) VALUES ('2', '4', '5',  '1');
INSERT INTO `matrix_cinema`.`reservation` (`id`, `row_number`, `seat_number`,  `schedule_id`) VALUES ('3', '1', '1',  '3');
INSERT INTO `matrix_cinema`.`reservation` (`id`, `row_number`, `seat_number`,  `schedule_id`) VALUES ('4', '3', '1',  '9');
INSERT INTO `matrix_cinema`.`reservation` (`id`, `row_number`, `seat_number`, `schedule_id`) VALUES ('5', '2', '11',  '4');
INSERT INTO `matrix_cinema`.`reservation` (`id`, `row_number`, `seat_number`,  `schedule_id`) VALUES ('6', '5', '4',  '4');


