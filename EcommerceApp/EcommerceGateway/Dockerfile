# Usar una imagen base de Java
FROM openjdk:17-jdk-alpine
# Establecer el directorio de trabajo
WORKDIR /app
# Copiar el archivo JAR generado
COPY target/EcommerceGateway-1.0.0.jar /app/EcommerceGateway-1.0.0.jar
# Exponer el puerto del servicio (8761 en este caso)
EXPOSE 8080
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/EcommerceGateway-1.0.0.jar"]
