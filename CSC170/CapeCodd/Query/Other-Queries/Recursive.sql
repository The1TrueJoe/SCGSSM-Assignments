SELECT S.BuyerName AS SupervisorName, 
	   S.Position AS SuperVisorPosition, 
       B.BuyerName, 
       B.Position
FROM BUYER S JOIN BUYER B
	ON S.BuyerName = B.Supervisor
ORDER BY S.BuyerName
;
