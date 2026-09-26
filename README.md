# Gestión de Enfermedades

Actividad individual unidad 1 en donde se realizo el ejercicio asignado numero 9 en donde se construyo web para consultar y administrar información de enfermedades. Incluye inicio de sesión, gestión de registros y filtros por nivel de gravedad. Está desarrollada con Java y Spring Boot, usa PostgreSQL como base de datos y se encuentra desplegada en Railway.

URL pública: https://desarollowebactividad1nathangama-production.up.railway.app/login

## Funcionalidades

- Inicio y cierre de sesión mediante una sesión HTTP.
- Listado y registro de enfermedades.
- Búsqueda de una enfermedad por su identificador.
- Filtro de enfermedades por nivel de gravedad: `Leve`, `Moderada`, `Grave` y `Critica`.
- Datos de cada enfermedad: nombre común y científico, gravedad, síntomas, medicamentos, contagio, cobertura por POS y requerimiento de incapacidad.
- Formulario para solicitar recuperación de acceso. Actualmente solo comprueba si el correo existe; no envía un correo ni cambia la contraseña.

## Tecnologías

- Java 21
- Spring Boot 4.1.1
- Spring MVC y Thymeleaf
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven Wrapper

## Requisitos

- JDK 21
- Una instancia de PostgreSQL
- PowerShell en Windows o una terminal compatible con Maven Wrapper

## Ejecución local

1. Clona el repositorio y entra en su carpeta:

   ```bash
   git clone https://github.com/ngamaj-est/desarollo_web_actividad_1_nathan_gama.git
   cd desarollo_web_actividad_1_nathan_gama
   ```

2. Crea una base de datos PostgreSQL vacía. Configura la conexión en el entorno antes de iniciar la aplicación.

   En PowerShell:

   ```powershell
   $env:SPRING_DATASOURCE_URL = "jdbc:postgresql://localhost:5432/GestionEnfermedades_db"
   $env:SPRING_DATASOURCE_USERNAME = "postgres"
   $env:SPRING_DATASOURCE_PASSWORD = "tu-clave-local"
   ```

   En Linux o macOS:

   ```bash
   export SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/GestionEnfermedades_db"
   export SPRING_DATASOURCE_USERNAME="postgres"
   export SPRING_DATASOURCE_PASSWORD="tu-clave-local"
   ```

3. Inicia la aplicación:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   En Linux o macOS usa `./mvnw spring-boot:run`.

### Cuentas de demostración

El script SQL carga estas cuentas iniciales:

| Correo | Contraseña | Rol |
| --- | --- | --- |
| `nathan.gama@admin.com` | `admin` | Administrador |
| `antonio.lopez@medico.com` | `medico123` | Medico |

## Rutas principales

| Ruta | Uso | Acceso |
| --- | --- | --- |
| `/` | Redirige al inicio de sesión | Público |
| `/login` | Muestra y procesa el inicio de sesión | Público |
| `/logout` | Cierra la sesión | Con sesión activa |
| `/enfermedades` | Lista las enfermedades | Con sesión activa |
| `/enfermedades/nuevaEnfermedad` | Muestra el formulario de registro | Con sesión activa |
| `/enfermedades/guardarEnfermedad` | Guarda un registro enviado por formulario | Formulario web |
| `/enfermedades/buscarEnfermedades?id={id}` | Busca por identificador | Con sesión activa |
| `/enfermedades/reporte/gravedad?nivel={nivel}` | Filtra por gravedad | Con sesión activa |
| `/enfermedades/eliminar/{id}` | Elimina un registro | Con sesión activa |
| `/recuperar` | Comprueba si existe el correo indicado | Formulario web |
