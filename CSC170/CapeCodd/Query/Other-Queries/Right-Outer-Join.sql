SELECT OI.OrderNumber, 
	   Quantity, 
       SD.SKU, 
       SKU_Description, 
       Department, 
       Buyer
FROM ORDER_ITEM AS OI RIGHT OUTER JOIN SKU_DATA AS SD
	ON OI.SKU = SD.SKU
ORDER BY OI.OrderNumber, SD.SKU
;