SELECT DISTINCT Buyer, Department
FROM SKU_DATA
WHERE SKU IN (
	SELECT SKU
    FROM ORDER_ITEM
    WHERE OrderNumber IN (
		SELECT OrderNumber
        FROM RETAIL_ORDER
        WHERE OrderMonth = 'January' AND OrderYear = 2018
        
        )
	)
;