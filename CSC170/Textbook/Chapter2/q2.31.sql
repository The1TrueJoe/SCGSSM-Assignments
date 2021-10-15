/*
**QUESTION 2.31**
Write an SQL statement to show a unique SKU and SKU_Description for all prod-
ucts with an SKU description starting with ‘Half-Dome’.
*/

SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE SKU_Description LIKE "Half-Dome%"
;