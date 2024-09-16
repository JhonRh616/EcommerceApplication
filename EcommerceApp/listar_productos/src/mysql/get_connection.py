import mysql.connector
from mysql.connector import Error

def connect_to_mysql():
    try:
        connection = mysql.connector.connect(
            host='ecommerce.crec20oc0bfb.us-east-2.rds.amazonaws.com',
            database='ecommerce',
            user='admin',
            password='Ecommerce1234*'
        )

        return connection

    except Error as e:
        print(f"Error al conectar a MySQL: {e}")

