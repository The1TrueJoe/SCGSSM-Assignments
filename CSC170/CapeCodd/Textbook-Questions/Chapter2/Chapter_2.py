#!/usr/bin/env python
# coding: utf-8

# # Chapter 2 Questions 2.25-2.39 Page 122

# In[1]:


import pymysql.cursors
import pandas as pd

# Connect to the database at 10.1.11.26
connection = pymysql.connect(
    host = "10.1.11.26",
    user = "jtelaak",
    password = "password",
    database = "cape_codd",
    charset = "utf8mb4",
    cursorclass = pymysql.cursors.DictCursor
)


# **QUESTION 2.25:**
# Write an SQL statement to display the SKU, SKU_Description, and WarehouseID for
# products that have a QuantityOnHand equal to 0. Sort the results in ascending order
# by WarehouseID.

# In[2]:


sql = "SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand = 0 ORDER BY WarehouseID ASC ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.26:**
# Write an SQL statement to display the SKU, SKU_Description, and WarehouseID for
# products that have a QuantityOnHand greater than 0. Sort the results in descending
# order by WarehouseID and in ascending order by SKU.

# In[3]:


sql = "SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand > 0 ORDER BY SKU ASC, WarehouseID DESC ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.27:**
# Write an SQL statement to display SKU, SKU_Description, and WarehouseID for all
# products that have a QuantityOnHand equal to 0 and a QuantityOnOrder greater than 0.
# Sort the results in descending order by WarehouseID and in ascending order by SKU.

# In[4]:


sql = ("SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand = 0 AND QuantityOnOrder > 0 " + 
    "ORDER BY WarehouseID DESC, SKU ASC ;")
    
df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.28:**
# Write an SQL statement to display SKU, SKU_Description, and WarehouseID for
# all products that have a QuantityOnHand equal to 0 or a QuantityOnOrder equal
# to 0. Sort the results in descending order by WarehouseID and in ascending order
# by SKU.

# In[5]:


sql = ("SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand = 0 AND QuantityOnOrder = 0 " + 
"ORDER BY WarehouseID DESC, SKU ASC ; ")

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **Question 2.29:**
# Write an SQL statement to display the SKU, SKU_Description, WarehouseID, and
# QuantityOnHand for all products having a QuantityOnHand greater than 1 and less
# than 10. Do not use the BETWEEN keyword.

# In[6]:


sql = ("SELECT SKU, SKU_Description, WarehouseID, QuantityOnHand FROM INVENTORY " + 
       " WHERE QuantityOnHand > 1 AND QuantityOnHand < 10 ;")

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.30:**
# Write an SQL statement to display the SKU, SKU_Description, WarehouseID, and
# QuantityOnHand for all products having a QuantityOnHand greater than 1 and less
# than 10. Use the BETWEEN keyword.

# In[7]:


sql = "SELECT SKU, SKU_DESCRIPTION, WarehouseID, QuantityOnHand FROM INVENTORY WHERE QuantityOnHand BETWEEN 1 AND 2"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.31**
# Write an SQL statement to show a unique SKU and SKU_Description for all prod-
# ucts with an SKU description starting with ‘Half-Dome’.

# In[8]:


sql = "SELECT DISTINCT SKU, SKU_Description FROM INVENTORY WHERE SKU_Description LIKE \"Half-Dome%\" ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.32**
# Write an SQL statement to show a unique SKU and SKU_Description for all prod-
# ucts with a description that includes the word ‘Climb’.

# In[9]:


sql = "SELECT DISTINCT SKU, SKU_Description FROM INVENTORY WHERE SKU_Description LIKE \"%Climb%\";"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.33**
# Write an SQL statement to show a unique SKU and SKU_Description for all prod-
# ucts with a ‘d’ in the third position from the left in SKU_Description.

# In[10]:


sql = "SELECT DISTINCT SKU, SKU_Description FROM INVENTORY WHERE SKU_Description LIKE \"__d%\";"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.34**
# Write an SQL statement that uses all of the SQL built-in functions on the Quantity-
# OnHand column. Include meaningful column names in the result.

# In[11]:


sql = "SELECT SKU, SKU_Description, SUM(QuantityOnHand) AS TotalOnHand, AVG(QuantityOnHand) AS AvgOnHand, MIN(QuantityOnHand) AS MinOnHand, MAX(QuantityOnHand)AS MaxOnHand, COUNT(QuantityOnHand) AS TotalWareHouseIDS FROM INVENTORY GROUP BY SKU_Description, SKU ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.35**
# Explain the difference between the SQL built-in functions COUNT and SUM.

# COUNT counts rows that meet the condition while SUM adds integers in a column.

# **QUESTION 2.36**
# Write an SQL statement to display the WarehouseID and the sum of QuantityOn-
# Hand grouped by WarehouseID. Name the sum TotalItemsOnHand and display the
# results in descending order of TotalItemsOnHand.

# In[12]:


sql = "SELECT WareHouseID, SUM(QuantityOnHand) AS TotalItemsOnHand FROM INVENTORY GROUP BY WareHouseID ORDER BY TotalItemsOnHand DESC ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.37**
# Write an SQL statement to display the WarehouseID and the sum of QuantityOn-
# Hand grouped by WarehouseID. Omit all SKU items that have three or more itemson hand from the sum, name the sum TotalItemsOnHandLT3, and display the results
# in descending order of TotalItemsOnHandLT3.

# In[13]:


sql = "SELECT WarehouseID, SUM(QuantityOnHand) as TotalItemsOnHandLT3 FROM INVENTORY WHERE QuantityOnHand < 3 GROUP BY WarehouseID ORDER BY TotalItemsOnHandLT3 DESC ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.38**
# Write an SQL statement to display the WarehouseID and the sum of Quantity
# OnHand grouped by WarehouseID. Omit all SKU items that have three or
# more items on hand from the sum, and name the sum TotalItemsOnHandLT3.
# Show the WarehouseID only for warehouses having fewer than two SKUs
# in their TotalItemsOnHandLT3. Display the results in descending order of
# TotalItemsOnHandLT3.

# In[14]:


sql = "SELECT WarehouseID, SUM(QuantityOnHand) as TotalItemsOnHandLT3 FROM INVENTORY WHERE QuantityOnHand < 3 GROUP BY WarehouseID HAVING TotalItemsOnHandLT3 < 2 ORDER BY TotalItemsOnHandLT3 DESC ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.39**
# In your answer to Review Question 2.38, was the WHERE clause or the HAVING
# clause applied first? Why?

# The MySQL clause order is FROM, WHERE, SELECT, GROUP BY, HAVING, ORDER BY. WHERE Was applied before HAVING.
