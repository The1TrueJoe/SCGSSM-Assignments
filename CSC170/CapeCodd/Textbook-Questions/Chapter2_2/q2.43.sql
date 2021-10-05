/*
2.43 Write an SQL statement to display the SKU, SKU_Description, WarehouseID,
WarehouseCity, and WarehouseState of all items not stored in the Atlanta, Bangor, or
Chicago warehouse. Use the NOT IN keyword.
*/

SELECT SKU, SKU_Description, INVENTORY.WarehouseID, WarehouseCity, WarehouseState 
FROM INVENTORY JOIN WAREHOUSE ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID 
WHERE WarehouseCity NOT IN ("Atlanta", "Bangor", "Chicago");