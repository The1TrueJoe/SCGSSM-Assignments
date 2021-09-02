/*
**QUESTION 2.27:**
Write an SQL statement to display SKU, SKU_Description, and WarehouseID for all
products that have a QuantityOnHand equal to 0 and a QuantityOnOrder greater than 0.
Sort the results in descending order by WarehouseID and in ascending order by SKU.
*/

SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE QuantityOnHand = 0 AND QuantityOnOrder > 0
ORDER BY WarehouseID DESC, SKU ASC
;