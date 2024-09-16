# EcommerceApplication

## Descripción del proyecto

La aplicación se encuentra desarrollada en dos backends expuestos en una instancia de EC2 de AWS, conectados a una base de datos MYSQL
creada en RDS, se gestionan los permisos de conexión por medio de un Usuario de IAM de AWS. El primer backend se encuentra desarrollado 
en el lenguaje de JAVA con el framework de SpringBoot, desarrollado como una simulación de una arquitectura de Microservicios y 
expone los servicios de crear-orden en una petición POST y el servicio de listar-ordenes en una petición GET, el segundo backend se encuentra desarrollado en Python en un Lambda de AWS, con arquitectura Sin Servidor y expone el servicio de listar-productos.
Adicional se encuentra un Frontend Desarrollado en Angular que se conecta a los servicios anteriormente mencionados.

También, dentro del proyecto se encuentran los archivos de configuración de cada proyecto en formato Docker y para su compilación y respectivo despliegue
un archivo de DockerCompose que se encargará de dicha gestión. 
Igualmente, en el repositorio se encuentra el archivo de configuración del Pipeline que es el encargado del despliegue en la instancia generada en EC2.

También existe un diagrama Relacional de la base de datos para su fácil entendimiento, así como un Swagger que documenta los servicios anteriormente descritos para el Backend desarrollado en JAVA. Igualmente, existe una carpeta con un diagrama de alto nivel para entender la manera en que fue desarrollado el proyecto en el programa de Draw.io, puede ser abierto desde la página web oficial o la aplicación de escritorio.
Por último, se encuentra el archivo que es la colección de postman creada para probar los servicios.


## Decisiones de diseño

Se creó el backend en Java Spring boot para los servicios relacionados con la gestión de ordenes, puesto que al ser peticiones más transaccionales
se permite una mejor gestión del contenido de los servicios, y, en caso de ocurrir un error, se podrá corregir en un backend más sólido y gestionable. Adicionalmente, se desarrolló con un arquitectura de microservicios para hacerlo más escalable, y que, en caso de que se requiera un nuevo nodo sea de facil registro para el servidor de Eureka y accesible mediante el GateWay generado, haciendo que sean independientes los microservicios uno del otro y que en caso de que uno se dañe el sistema pueda seguir funcionando correctamente.
El backend generado como un Lambda de AWS en Python, fue elaborado de este modo al ser una petición únicamente de consulta, por lo que buscamos algo sencillo.
El Frontend fue desarrollado en Angular porque al ser un framework bastante popular, se vuelve escalable y de facil mantenimiento para los desarrolladores.

## Creación del Pipeline CI/CD

El Pipeline consta de los siguientes pasos, se conmfigura la versión de JAVA 17 que es la que usan los proyectos maven para compilar, e igualmente se compilan los proyectos con Maven, posteriormente se hace Login a ECR que es donde se subirán las imágenes Docker de cada proyecto (con anterioridad fueron creadas), y se continúa construyendo una a una las imágenes Docker de cada proyecto, posteriormente se suben a ECR y en el paso final ejecuta el archivo de DockerCompose que se encarga de desplegar las imágenes y crear la "ecommerce-network", que es la red por la que se comunicarán los microservicios y serán accesibles entre ellos.

## Instrucciones de uso

Dentro del repositorio se encuentra una colección de Postman llamada EcommerceApp.postman_collection.json que puede ser importada desde el programa Postman para probar los servicios expuestos en la instancia de EC2 de AWS, estas apuntan directamente a las URL de la instancia y no habría que hacer nada más para que funcione.

Para probar el Frontend localmente basta con importar el proyecto a un programa como Visual Studio o usar la consola para correrlo con el comando "npm start", para esto se debe contar con Angular y Node con anterioridad.

La Url del Swagger con los servicios es la siguiente: http://3.138.186.134:8081/swagger-ui/index.html#/
La Url del Front con los servicios es la siguiente: http://3.138.186.134:8085

## Conexión a base de datos

Para conectarse a base de datos es necesario usar un gestor de base de datos con las siguientes credenciales 

Host: ecommerce.crec20oc0bfb.us-east-2.rds.amazonaws.com
Puerto: 3306
Base de Datos: ecommerce
Usuario: admin
Contraseña: Ecommerce1234*
