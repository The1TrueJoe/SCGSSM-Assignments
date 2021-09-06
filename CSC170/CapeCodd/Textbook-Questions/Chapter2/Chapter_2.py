#!/usr/bin/env python
# coding: utf-8

# # Chapter 2 Questions 2.25-2.39 Page 122

# In[15]:


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

# In[16]:


sql = "SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand = 0 ORDER BY WarehouseID ASC ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.26:**
# Write an SQL statement to display the SKU, SKU_Description, and WarehouseID for
# products that have a QuantityOnHand greater than 0. Sort the results in descending
# order by WarehouseID and in ascending order by SKU.

# In[17]:


sql = "SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand > 0 ORDER BY SKU ASC, WarehouseID DESC ;"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.27:**
# Write an SQL statement to display SKU, SKU_Description, and WarehouseID for all
# products that have a QuantityOnHand equal to 0 and a QuantityOnOrder greater than 0.
# Sort the results in descending order by WarehouseID and in ascending order by SKU.

# In[18]:


sql = ("SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand = 0 AND QuantityOnOrder > 0 " + 
    "ORDER BY WarehouseID DESC, SKU ASC ;")
    
df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.28:**
# Write an SQL statement to display SKU, SKU_Description, and WarehouseID for
# all products that have a QuantityOnHand equal to 0 or a QuantityOnOrder equal
# to 0. Sort the results in descending order by WarehouseID and in ascending order
# by SKU.

# In[19]:


sql = ("SELECT SKU, SKU_Description, WarehouseID FROM INVENTORY WHERE QuantityOnHand = 0 AND QuantityOnOrder = 0 " + 
"ORDER BY WarehouseID DESC, SKU ASC ; ")

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **Question 2.29:**
# Write an SQL statement to display the SKU, SKU_Description, WarehouseID, and
# QuantityOnHand for all products having a QuantityOnHand greater than 1 and less
# than 10. Do not use the BETWEEN keyword.

# In[21]:


sql = ("SELECT SKU, SKU_Description, WarehouseID, QuantityOnHand FROM INVENTORY " + 
       " WHERE QuantityOnHand > 1 AND QuantityOnHand < 10 ;")

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# **QUESTION 2.30:**
# Write an SQL statement to display the SKU, SKU_Description, WarehouseID, and
# QuantityOnHand for all products having a QuantityOnHand greater than 1 and less
# than 10. Use the BETWEEN keyword.

# In[22]:


sql = "SELECT SKU, SKU_DESCRIPTION, WarehouseID, QuantityOnHand FROM INVENTORY WHERE QuantityOnHand BETWEEN 1 AND 2"

df = pd.read_sql_query(sql, connection)
df.tail(1000)


# In[ ]:




