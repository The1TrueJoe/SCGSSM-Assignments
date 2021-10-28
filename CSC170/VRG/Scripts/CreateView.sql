USE vrg09;

CREATE VIEW CustomerNameView AS
    SELECT LastName as CustomerLastName,
           FirstName as CustomerFirstName
    FROM CUSTOMER
;