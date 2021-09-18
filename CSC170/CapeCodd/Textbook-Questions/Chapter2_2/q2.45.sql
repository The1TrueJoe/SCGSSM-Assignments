/*
2.45 Write an SQL statement to show the SKU, SKU_Description, and WarehouseID for
all items stored in a warehouse managed by ‘Lucille Smith’. Use a subquery.
*/

SELECT SKU, SKU_Description, WarehouseID 
FROM INVENTORY 
WHERE WarehouseID IN (
    SELECT WarehouseID 
    FROM WAREHOUSE 
    WHERE Manager = "Lucille Smith"
);