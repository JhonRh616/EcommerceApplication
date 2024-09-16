# Usar una imagen base de Java
FROM openjdk:17-jdk-alpine
# Establecer el directorio de trabajo
WORKDIR /app
# Copiar el archivo JAR generado
COPY target/EcommerceConfig-1.0.0.jar /app/EcommerceConfig-1.0.0.jar
# Exponer el puerto del servicio
EXPOSE 8888
# Comando para ejecutar la aplicación con el perfil 'native'
ENTRYPOINT ["java", "-jar", "/app/EcommerceConfig-1.0.0.jar", "--spring.profiles.active=native"]
