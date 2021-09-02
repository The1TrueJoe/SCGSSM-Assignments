/*
**QUESTION 2.25:**
Write an SQL statement to display the SKU, SKU_Description, and WarehouseID for
products that have a QuantityOnHand equal to 0. Sort the results in ascending order
by WarehouseID.
*/

SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE QuantityOnHand = 0
ORDER BY WarehouseID ASC
;
