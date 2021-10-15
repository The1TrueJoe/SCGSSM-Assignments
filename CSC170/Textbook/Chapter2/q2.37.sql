/*
**QUESTION 2.37**
Write an SQL statement to display the WarehouseID and the sum of QuantityOn-
Hand grouped by WarehouseID. Omit all SKU items that have three or more itemson hand from the sum, name the sum TotalItemsOnHandLT3, and display the results
in descending order of TotalItemsOnHandLT3.
*/

SELECT WarehouseID, SUM(QuantityOnHand) as TotalItemsOnHandLT3
FROM INVENTORY
WHERE QuantityOnHand < 3
GROUP BY WarehouseID
ORDER BY TotalItemsOnHandLT3 DESC
;