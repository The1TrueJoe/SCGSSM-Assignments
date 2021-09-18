/*
2.52 Write an SQL statement to display the WarehouseID, the sum of QuantityOnOrder,
and the sum of QuantityOnHand, grouped by WarehouseID and QuantityOnOrder.
Name the sum of QuantityOnOrder as TotalItemsOnOrder and the sum of Quantity
OnHand as TotalItemsOnHand. Use only the INVENTORY table in your SQL
statement.
*/

SELECT WarehouseID, SUM(QuantityOnOrder) AS TotalItemsOnOrder, SUM(QuantityOnHand) AS TotalItemsOnHand 
FROM INVENTORY 
GROUP BY WarehouseID, QuantityOnOrder;