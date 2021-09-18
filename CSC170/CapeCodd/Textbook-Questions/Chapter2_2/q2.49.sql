/*
2.49 Write an SQL statement to show the WarehouseID and average QuantityOnHand of
all items stored in a warehouse managed by ‘Lucille Smith’. Use a join, but do not use
JOIN ON syntax.
*/

SELECT INVENTORY.WarehouseID, AVG(QuantityOnHand)
FROM INVENTORY JOIN WAREHOUSE 
WHERE INVENTORY.WarehouseID = WAREHOUSE.WarehouseID AND Manager = "Lucille Smith" 
GROUP BY WarehouseID;