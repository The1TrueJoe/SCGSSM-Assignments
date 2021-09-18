/*
2.44 Write an SQL statement to produce a single column called ItemLocation that com-
bines the SKU_Description, the phrase “is located in,” and WarehouseCity. Do not be
concerned with removing leading or trailing blanks.
*/

SELECT CONCAT(INVENTORY.SKU_Description, " located in ", WAREHOUSE. WarehouseCity) AS ItemLocation 
FROM INVENTORY JOIN WAREHOUSE ON INVENTORY. WarehouseID = WAREHOUSE.WarehouseID;