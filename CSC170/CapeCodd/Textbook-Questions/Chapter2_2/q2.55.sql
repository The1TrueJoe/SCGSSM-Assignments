/*
2.55 Write an SQL statement to join WAREHOUSE and INVENTORY and include all
rows of WAREHOUSE in your answer, regardless of whether they have any INVEN-
TORY. Include all columns of both tables, but do not repeat the join column.
*/

SELECT WAREHOUSE.WarehouseID, WAREHOUSE.WarehouseCity, WAREHOUSE. WarehouseCity, WAREHOUSE.SquareFeet, WAREHOUSE.Manager, INVENTORY.SKU, INVENTORY.SKU_Description, INVENTORY.QuantityOnHand, INVENTORY. QuantityOnOrder 
FROM WAREHOUSE LEFT OUTER JOIN INVENTORY ON WAREHOUSE.WarehouseID = INVENTORY.WarehouseID;