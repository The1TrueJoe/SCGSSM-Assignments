/*
2.51 Write an SQL statement to show the WarehouseID, WarehouseCity, WarehouseState,
Manager, SKU, SKU_Description, and QuantityOnHand of all items stored in a ware-
house managed by ‘Lucille Smith’. Use a join using JOIN ON syntax.
*/

SELECT WAREHOUSE.WarehouseID, WAREHOUSE.WarehouseCity, WAREHOUSE. WarehouseState, WAREHOUSE.Manager, INVENTORY.SKU, INVENTORY.SKU_Description, INVENTORY.QuantityOnHand 
FROM WAREHOUSE JOIN INVENTORY ON WAREHOUSE. WarehouseID = INVENTORY.WarehouseID 
WHERE Manager = "Lucille Smith";