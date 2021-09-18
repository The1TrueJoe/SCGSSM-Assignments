/*
2.47 Write an SQL statement to show the SKU, SKU_Description, and WarehouseID for
all items stored in a warehouse managed by ‘Lucille Smith’. Use a join using JOIN ON
syntax.
*/

SELECT SKU, SKU_Description, INVENTORY.WarehouseID 
FROM INVENTORY JOIN WAREHOUSE ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID 
WHERE WAREHOUSE.Manager = 'Lucille Smith';