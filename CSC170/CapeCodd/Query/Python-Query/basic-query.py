# Connect to a database and send a SQL request
# GSSM CSC170 Database
# Joseph Telaak

import pymysql.cursors

# Define database connection
connection = pymysql.connect(
                host="10.1.11.26",
                user="jtelaak",
                password="password",
                database="cape_codd",
                cursorclass=pymysql.cursors.DictCursor
             )

with connection.cursor() as cursor:
    # Build and send query
    query = "SELECT Department FROM SKU_DATA; "
    cursor.execute(query)
    
    # Get results
    result = cursor.fetchall()
    
    # Display results
    for r in result:
        print(r)
        
# Close
cursor.close()
connection.close()