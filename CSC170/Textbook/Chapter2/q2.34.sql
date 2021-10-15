/*
**QUESTION 2.34**
Write an SQL statement that uses all of the SQL built-in functions on the Quantity-
OnHand column. Include meaningful column names in the result.
*/

SELECT
    SKU,
    SKU_Description,
    SUM(QuantityOnHand) AS TotalOnHand,
    AVG(QuantityOnHand) AS AvgOnHand,
    MIN(QuantityOnHand) AS MinOnHand,
    MAX(QuantityOnHand)AS MaxOnHand,
    COUNT(QuantityOnHand) AS TotalWareHouseIDS
FROM INVENTORY
GROUP BY SKU_Description, SKU
;