
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (1, 17, 'American Express');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (2, 44, 'MasterCard');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (3, 15, 'MasterCard');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (4, 18, 'Visa');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (5, 28, 'MasterCard');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (6, 35, 'MasterCard');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (7, 29, 'MasterCard');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (8, 34, 'MasterCard');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (9, 21, 'MasterCard');
INSERT INTO `Payment` (`paymentId`, `cost`, `method`) VALUES (10, 39, 'American Express');
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (1, 'Venus', 40);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (2, 'Jupiter', 33);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (3, 'Mercury', 29);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (4, 'Puto', 25);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (5, 'Mars', 12);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (6, 'Earth', 31);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (7, 'Neptune', 24);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (8, 'Sun', 14);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (9, 'Uranus', 22);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (10, 'Nimiri', 33);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (11, 'Titan', 33);
INSERT INTO `RecreationCenter` (`recCenterId`, `name`, `rentalPricePerHour`) VALUES (12, 'Sirius', 33);
INSERT INTO `User` (`username`, `password`, `isAdmin`) VALUES ('kenny.huynh', 'student', 1);
INSERT INTO `User` (`username`, `password`, `isAdmin`) VALUES ('hiep.tran', 'student', 1);
INSERT INTO `User` (`username`, `password`, `isAdmin`) VALUES ('john.tran', 'student', 1);
INSERT INTO `User` (`username`, `password`, `isAdmin`) VALUES ('jean.marcellin', 'student', 1);
INSERT INTO `User` (`username`, `password`, `isAdmin`) VALUES ('suneuy.kim', 'teacher', 1);
INSERT INTO `User` (`username`, `password`, `isAdmin`) VALUES ('user1', 'user1password', 0);
INSERT INTO `User` (`username`, `password`, `isAdmin`) VALUES ('user2', 'user2password', 0);
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (1, 2, 'Hard');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (2, 3, 'Hard');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (3, 7, 'Grass');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (4, 3, 'Hard');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (5, 6, 'Sand');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (6, 3, 'Sand');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (7, 10, 'Sand');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (8, 8, 'Grass');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (9, 1, 'Sand');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (10, 4, 'Grass');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (11, 12, 'Grass');
INSERT INTO `TennisCourt` (`tennisCourtId`, `recCenterId`, `type`) VALUES (12, 11, 'Grass');
INSERT INTO `Archive` (`reservationId`, `username`, `tennisCourtId`, `paymentId`, `reservationTimeStart`, `reservationTimeEnd`, `updateAt`) VALUES ('1', 'alysson.lowe', '1', '15', '2018-12-01 15:30:00', '2018-12-01 16:00:00', '2018-10-01 08:00:00'),
('2', 'user1', '2', '68', '2018-11-23 14:00:00', '2018-11-23 14:30:00', '2018-10-01 08:00:00'),
('3', 'user1', '3', '34', '2018-11-25 08:30:00', '2018-11-25 09:00:00', '2018-10-01 08:00:00'),
('4', 'user1', '4', '19', '2018-11-29 12:00:00', '2018-11-29 12:30:00', '2018-10-01 08:00:00'),
('5', 'user2', '5', '54', '2018-12-04 14:30:00', '2018-12-04 15:00:00', '2018-10-01 08:00:00'),
('6', 'user2', '6', '32', '2018-11-18 09:00:00', '2018-11-18 09:30:00', '2018-10-01 08:00:00'),
('7', 'user2', '7', '87', '2018-10-02 12:30:00', '2018-10-02 13:00:00', '2018-10-01 08:00:00'),
