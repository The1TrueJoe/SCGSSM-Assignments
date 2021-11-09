USE cape_codd;

CREATE FUNCTION dbo.NameConcatenation (
	@FirstName CHAR(25)
    @LastName CHAR(25)
)
RETURNS VARCHAR(60) 
AS 
BEGIN
	DECLARE @FullName VARCHAR(60);
    SELECT @FullName = RTRIM(@LastName) + ', ' + RTRIM(@FirstName);