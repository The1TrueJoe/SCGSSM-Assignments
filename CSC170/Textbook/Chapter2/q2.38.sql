/*
**QUESTION 2.38**
Write an SQL statement to display the WarehouseID and the sum of Quantity
OnHand grouped by WarehouseID. Omit all SKU items that have three or
more items on hand from the sum, and name the sum TotalItemsOnHandLT3.
Show the WarehouseID only for warehouses having fewer than two SKUs
in their TotalItemsOnHandLT3. Display the results in descending order of
TotalItemsOnHandLT3.
*/

SELECT WarehouseID, SUM(QuantityOnHand) as TotalItemsOnHandLT3
FROM INVENTORY
WHERE QuantityOnHand < 3
GROUP BY WarehouseID
HAVING TotalItemsOnHandLT3 < 2
ORDER BY TotalItemsOnHandLT3 DESC
;