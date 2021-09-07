SELECT SKU, SKU_Description, CONCAT(Buyer, ' in ', Department) AS Sponsor
FROM SKU_DATA
ORDER BY Sponsor
;