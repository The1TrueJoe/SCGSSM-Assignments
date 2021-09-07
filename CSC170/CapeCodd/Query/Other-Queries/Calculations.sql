SELECT  SUM(ExtendedPrice) AS OrderItemSum,
		AVG(ExtendedPrice) AS OrderItemAvg,
        MIN(ExtendedPrice) AS OrderItemMin,
        MAX(ExtendedPrice) AS OrderItemMax
FROM ORDER_ITEM
;