import json

from src.api import get_mysql_information

def get_productos(event, context):
    productos = get_mysql_information.get_productos()
    products = []
    for producto in productos:
        products.append({"id":producto[0],"nombre":producto[1],"precio":producto[2],"proveedor":producto[3],"tipoProducto":producto[4],"cantidad":producto[5]})
    res = {
        'statusCode': 200,
        'body': json.dumps(products),
        'headers': {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",  
            "Access-Control-Allow-Methods": "GET, POST, OPTIONS",  
            "Access-Control-Allow-Headers": "Content-Type, Authorization",  
            "Accept": "application/json"
        }
    }
    return res
    