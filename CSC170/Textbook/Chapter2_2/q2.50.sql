/*
2.50 Write an SQL statement to show the WarehouseID and average QuantityOnHand of
all items stored in a warehouse managed by ‘Lucille Smith’. Use a join using JOIN ON
syntax.
*/

SELECT INVENTORY.WarehouseID, AVG(QuantityOnHand) 
FROM INVENTORY JOIN WAREHOUSE ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID 
WHERE Manager = "Lucille Smith" GROUP BY WarehouseID;