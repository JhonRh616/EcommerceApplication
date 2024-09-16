from src.mysql import get_connection
from mysql.connector import Error

def get_productos():
    connection = None
    product = {}
    try:
        connection = get_connection.connect_to_mysql()
        cursor = connection.cursor()
        sql = (
            'SELECT p.id_producto, p.nombre_producto, p.valor_producto, '
            'p2.nombre_proveedor, tp.descripcion_tipo, p.cantidad_disponible '
            'FROM producto AS p '
            'INNER JOIN proveedor p2 ON p.id_proveedor = p2.id_proveedor '
            'INNER JOIN tipo_producto tp ON p.id_tipo_producto = tp.id_tipo_producto'
        )
        cursor.execute(sql)
        product = cursor.fetchall()
        cursor.close()
        return product
    except Error as e:
        return e
    finally:
        if connection is not None:
            connection.close()


