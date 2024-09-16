# Etapa 1: Construir la aplicación Angular
FROM node:16-alpine AS build

WORKDIR /app

# Copia los archivos package.json y package-lock.json
COPY package*.json ./

# Instala las dependencias de Node.js
RUN npm install

# Copia el resto del código de la aplicación
COPY . .

# Compila la aplicación Angular para producción
RUN npm run build --prod

# Etapa 2: Configuración de NGINX para servir la aplicación
FROM nginx:alpine

# Copia los archivos generados del build de Angular al contenedor NGINX
COPY --from=build /app/dist/ecommerce-front /usr/share/nginx/html

# Copia el archivo de configuración personalizado de NGINX
COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf

# Expone el puerto que has configurado en NGINX (8085 en este caso)
EXPOSE 8085

# Comando para iniciar NGINX
CMD ["nginx", "-g", "daemon off;"]
