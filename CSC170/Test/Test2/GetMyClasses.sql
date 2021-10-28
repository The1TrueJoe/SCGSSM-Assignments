USE TESTSCHEMA09;

SELECT *
FROM CLASSES
WHERE InstructorID IN (
        SELECT InstructorID
        FROM INSTRUCTOR
        WHERE Name LIKE 'Joseph'
    )
;