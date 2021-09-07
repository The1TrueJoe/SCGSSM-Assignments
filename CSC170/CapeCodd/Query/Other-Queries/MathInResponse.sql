SELECT OrderNumber, SKU, (Quantity * Price) AS EST_VALUE
FROM ORDER_ITEM
ORDER BY SKU ASC, EST_VALUE DESC
;