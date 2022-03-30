-- procedure to get all the passengers
DROP PROCEDURE IF EXISTS GetAllPassenger;
DELIMITER //
CREATE PROCEDURE GetAllPassenger()
BEGIN
	SELECT *  FROM passenger;
END //
DELIMITER ;

-- funtion to return the number of years the pasenger has join the database
DROP FUNCTION IF EXISTS PassengeYears;

DELIMITER //
CREATE FUNCTION PassengeYears(
	startdate datetime
) 
RETURNS int
DETERMINISTIC
BEGIN
 DECLARE date2 DATE;
  Select current_date.year() into date2;
  RETURN year(date2)-year(startdate.year());
END //
DELIMITER ;