# Pasos para iniciar el servidor y cargar usuarios

Esta aplicación muestra en el navegador los usuarios guardados en MySQL. El botón **Cargar usuarios** consulta la API `GET http://localhost:8080/usuarios`; no agrega usuarios a la base de datos.

## Requisitos

- Java 21.
- MySQL en ejecución y accesible en `localhost:3306`.
- Visual Studio Code con la extensión **Live Server** para servir el frontend.

## 1. Preparar la base de datos

En MySQL Workbench o en otro cliente MySQL, ejecuta este SQL para crear la base de datos y la tabla que utiliza la aplicación:

```sql
create database conexion_db;
use conexion_db;

create table usuarios (
idUsuario int auto_increment primary key,
nombre varchar(100),
correo varchar(100)
);

select * from usuarios;
describe usuarios;
```

Para agregar usuarios de ejemplo, ejecuta:

```sql
INSERT INTO usuarios (nombre, correo)
VALUES
('Juan Pérez', 'juan@gmail.com'),
('María López', 'maria@gmail.com'),
('Jose Manuel', 'jose@gmail.com');
```

Puedes consultar lo que quedó guardado con:

```sql
SELECT idUsuario, nombre, correo FROM usuarios;
```

## 2. Configurar la conexión a MySQL

Abre `conexion-db/src/main/resources/application.properties` y verifica que la URL, el usuario y la contraseña correspondan a tu instalación de MySQL. La configuración del proyecto espera la base de datos `conexion_db` en el puerto `3306`; si tu contraseña no está configurada o es distinta, actualiza `spring.datasource.password`.

La aplicación no crea ni modifica tablas automáticamente, por lo que debes ejecutar el SQL del paso anterior antes de iniciar el servidor.

## 3. Iniciar el servidor API

Desde la carpeta raíz del proyecto, abre una terminal PowerShell y ejecuta:

```powershell
cd .\conexion-db
.\mvnw.cmd spring-boot:run
```

Deja esa terminal abierta. Cuando Spring Boot termine de iniciar, la API estará disponible en `http://localhost:8080`.

Puedes comprobar la conexión y la respuesta de la API abriendo `http://localhost:8080/usuarios` en el navegador. Debe aparecer un arreglo JSON con los registros de la tabla; si no hay registros, aparecerá `[]`.

## 4. Abrir el frontend y cargar los usuarios

1. En VS Code, abre la carpeta `Frontend` del proyecto.
2. Haz clic derecho en `index.html` y selecciona **Open with Live Server**.
3. Verifica que la página se abra con el origen `http://127.0.0.1:5500` (es el origen permitido por la API).
4. Haz clic en **Cargar usuarios**. Los registros de MySQL aparecerán en la página.

Si agregas usuarios mientras la página ya está abierta, vuelve a pulsar **Cargar usuarios** para consultar la lista actualizada.

## Solución de problemas

- **Error de conexión a MySQL:** confirma que MySQL esté activo, que la base de datos exista y que las credenciales de `application.properties` sean correctas.
- **La API no inicia por falta de tabla:** ejecuta el SQL del paso 1; JPA está configurado para no crear tablas automáticamente.
- **No se puede acceder a `localhost:8080`:** confirma que la terminal del servidor siga abierta y que Spring Boot haya iniciado correctamente.
- **El navegador muestra un error CORS:** abre el frontend con Live Server usando `http://127.0.0.1:5500`, no con `file://` ni con otro puerto u origen.
