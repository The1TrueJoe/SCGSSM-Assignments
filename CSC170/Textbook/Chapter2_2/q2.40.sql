/*
* 2.40 Write an SQL statement to display the SKU, SKU_Description, WarehouseID,
* WarehouseCity, and WarehouseState for all items stored in the Atlanta, Bangor, or
* Chicago warehouse. Do not use the IN keyword.
*/

SELECT SKU, SKU_Description, INVENTORY.WarehouseID, WarehouseCity, WarehouseState 
FROM INVENTORY 
JOIN WAREHOUSE ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID 
WHERE WarehouseCity = "Atlanta" OR WarehouseCity = "Bangor" OR WarehouseCity = "Chicago";