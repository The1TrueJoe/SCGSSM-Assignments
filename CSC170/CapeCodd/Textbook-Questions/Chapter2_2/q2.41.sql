/*
2.41 Write an SQL statement to display the SKU, SKU_Description, WarehouseID,
WarehouseCity, and WarehouseState for all items stored in the Atlanta, Bangor, or
Chicago warehouse. Use the IN keyword.
*/

SELECT SKU, SKU_Description, INVENTORY.WarehouseID, WarehouseCity, WarehouseState 
FROM INVENTORY JOIN WAREHOUSE ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID 
WHERE WarehouseCity IN ("Atlanta", "Bangor", "Chicago");
