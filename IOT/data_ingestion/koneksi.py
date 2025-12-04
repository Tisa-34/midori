import mysql.connector
# Connect to server
cnx = mysql.connector.connect(
    host="127.0.0.1",
    port=3306,
    user="root",
    password="",
    database='iot_db')

# Get a cursor
cur = cnx.cursor()

# Execute a query
# cur.execute("SELECT CURDATE()")
# Fetch one result
# row = cur.fetchone()
# print("Current date is: {0}".format(row[0]))

tesTambahData = "INSERT INTO sersor (ultrasonik, waktu) VALUES (%s, NOW())"
#tesTambahData = ("INSERT INTO sensor " "(ultrasonik)" "VALUES (%s)")
data_ultrasonik = ("100",)
cur.execute(tesTambahData, data_ultrasonik)
cnx.commit()
cur.close()


# Close connection
cnx.close()

#####
