SELECT SUM(ExtendedPrice) as WaterSportsRevenue
FROM ORDER_ITEM
WHERE SKU IN (
	SELECT SKU
    FROM SKU_DATA
    WHERE Department = 'Water Sports'
    
	)
;