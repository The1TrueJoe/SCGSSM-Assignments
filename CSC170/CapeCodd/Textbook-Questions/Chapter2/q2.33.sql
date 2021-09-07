/*
**QUESTION 2.33**
Write an SQL statement to show a unique SKU and SKU_Description for all prod-
ucts with a ‘d’ in the third position from the left in SKU_Description.
*/

SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE SKU_Description LIKE "__d%"
;