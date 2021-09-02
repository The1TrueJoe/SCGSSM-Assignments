/*
**QUESTION 2.30:**
Write an SQL statement to display the SKU, SKU_Description, WarehouseID, and
QuantityOnHand for all products having a QuantityOnHand greater than 1 and less
than 10. Use the BETWEEN keyword.
*/

SELECT SKU, SKU_DESCRIPTION, WarehouseID, QuantityOnHand
FROM INVENTORY
WHERE QuantityOnHand BETWEEN 1 AND 2
;