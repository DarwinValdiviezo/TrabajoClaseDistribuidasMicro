# Trabajo Clase Distribuidas - RECLAMOS

## 🛠️ Importante

Este Trabajo esta desarrollado sobre RECLAMOS no sobre cursos, se uso la estructura de cursos por errores en maven y jar.

---

Este proyecto es una API REST desarrollada con **Spring Boot**, diseñada para gestionar un sistema de reclamos. A continuación, se describen los pasos detallados para clonar, configurar y ejecutar el proyecto en tu entorno local.

---

## 🛠️ Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu máquina:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (versión Ultimate recomendada para soporte completo de Spring Boot).
- [Docker Desktop](https://www.docker.com/products/docker-desktop/).
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).
- [Postman](https://www.postman.com/) o cualquier herramienta para realizar pruebas API.
- **Java 17** (puedes verificar la versión con `java -version` en tu terminal).
- **Maven** (debería venir integrado con IntelliJ IDEA).

---

## 🚀 Pasos para ejecutar el proyecto

### 1. Clonar el repositorio

1. Abre tu terminal o línea de comandos y clona el repositorio del proyecto:
   ```bash
   git clone https://github.com/DarwinValdiviezo/TrabajoClaseDistribuidasMicro.git
   ```

### 2. Ingresa al directorio del proyecto:

```bash
 cd TrabajoClaseDistribuidasMicro
```

### 3. Abre el proyecto en IntelliJ IDEA:

- Inicia IntelliJ IDEA.
- Selecciona File > Open... y elige la carpeta del proyecto que acabas de clonar.

## 🚀 Configuración de Docker para la base de datos

- Asegúrate de que Docker Desktop esté ejecutándose correctamente en tu máquina.

- Descarga la última imagen de MySQL ejecutando el siguiente comando en tu terminal:

```bash
docker pull mysql:latest
```

- Crea un contenedor de MySQL usando el comando:

```bash
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -d -p 3308:3306 mysql:latest
```

- --name mysql-container: Define el nombre del contenedor como mysql-container.
- -e MYSQL_ROOT_PASSWORD=rootpassword: Establece la contraseña del usuario root.
- -p 3308:3306: Expone el puerto 3306 del contenedor en el puerto 3308 de tu máquina.

### 1. Abre MySQL Workbench y crea una conexión a la base de datos:

- Hostname: localhost.
- Port: 3308.
- Username: root.
- Password: rootpassword.
- Una vez conectado, puedes administrar y explorar las tablas del proyecto.

## 🚀 Ejecutar el contenedor de la aplicación

- Ve al directorio del archivo micro-cursos:

```bash
cd micro-cursos
```

- Construye el contenedor de Docker para la aplicación:

```bash
docker compose build
```

- Una vez construido, ejecuta la aplicación:

```bash
docker compose up
```

## 🚀 Probar la API

- Abre un navegador y verifica si la API está funcionando accediendo a la siguiente URL:

```bash
http://localhost:8005/api/reclamo
```

- Para realizar pruebas en Postman, utiliza el siguiente JSON para crear un reclamo con una solicitud POST a la URL http://localhost:8005/api/reclamo:

```bash
{
  "cliente": "Darwin C",
  "descripcion": "No llegó mi pedido.",
  "prioridad": 5,
  "fechaReclamo": "2025-01-15"
}
```

-Asegúrate de que las respuestas sean correctas y ajusta los parámetros según sea necesario.
