SELECT SUM(ExtendedPrice) as WaterSportsRevenue
FROM ORDER_ITEM
WHERE SKU IN (100100, 100200, 100300, 100400, 100500, 100600, 101100, 101200)
;