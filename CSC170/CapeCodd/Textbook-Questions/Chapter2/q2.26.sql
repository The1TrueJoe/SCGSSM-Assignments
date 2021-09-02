/*
**QUESTION 2.26:**
Write an SQL statement to display the SKU, SKU_Description, and WarehouseID for
products that have a QuantityOnHand greater than 0. Sort the results in descending
order by WarehouseID and in ascending order by SKU.
*/

SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE QuantityOnHand > 0
ORDER BY SKU ASC, WarehouseID DESC
;