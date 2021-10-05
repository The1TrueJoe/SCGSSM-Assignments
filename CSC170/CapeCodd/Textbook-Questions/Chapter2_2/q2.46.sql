/*
2.46 Write an SQL statement to show the SKU, SKU_Description, and WarehouseID for
all items stored in a warehouse managed by ‘Lucille Smith’. Use a join, but do not use
JOIN ON syntax.
*/

SELECT SKU, SKU_Description, INVENTORY.WarehouseID 
FROM INVENTORY JOIN WAREHOUSE WHERE INVENTORY.WarehouseID = WAREHOUSE.WarehouseID AND WAREHOUSE.Manager = "Lucille Smith";