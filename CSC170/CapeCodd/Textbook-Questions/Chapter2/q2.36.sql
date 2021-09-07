/*
**QUESTION 2.36**
Write an SQL statement to display the WarehouseID and the sum of QuantityOn-
Hand grouped by WarehouseID. Name the sum TotalItemsOnHand and display the
results in descending order of TotalItemsOnHand.
*/

SELECT WareHouseID, SUM(QuantityOnHand) AS TotalItemsOnHand
FROM INVENTORY
GROUP BY WareHouseID
ORDER BY TotalItemsOnHand DESC
;