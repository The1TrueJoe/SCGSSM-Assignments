/*
**QUESTION 2.32**
Write an SQL statement to show a unique SKU and SKU_Description for all prod-
ucts with a description that includes the word ‘Climb’.
*/

SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE SKU_Description LIKE "%Climb%"
;