/* 
**Question 2.29:**
Write an SQL statement to display the SKU, SKU_Description, WarehouseID, and
QuantityOnHand for all products having a QuantityOnHand greater than 1 and less
than 10. Do not use the BETWEEN keyword.
*/

SELECT SKU, SKU_Description, WarehouseID, QuantityOnHand
FROM INVENTORY
WHERE QuantityOnHand > 1 AND QuantityOnHand < 10
;