/*
2.48 Write an SQL statement to show the WarehouseID and average QuantityOnHand of
all items stored in a warehouse managed by ‘Lucille Smith’. Use a subquery.
*/

SELECT AVG(QuantityOnHand), INVENTORY.WarehouseID 
FROM INVENTORY 
WHERE WarehouseID IN (
    SELECT WarehouseID 
    FROM WAREHOUSE 
    WHERE Manager = "Lucille Smith"
)
GROUP BY WarehouseID;