# AppTareasJava
Prueba tecnica sobre un backend de Java con SpringBoot framework, Swagger y prueba unitarias JUnit

## Tecnologías
- Java
- SpringBoot
- Swagger
- JUnit


## Instrucciones de instalación

- Clonar el proyecto
```bash
    https://github.com/BartRoig/AppTareasJava.git
```
- Ejecutar script Script_Base_De_Datos.sql en una instalación de MySQL server 8
- Importar proyecto de carpeta "Tareas" en Eclipse IDE
- Navegar hacia documento application.properties en src\main\resources y cambiar las credenciales de la base de datos con las siguientes lineas:
```bash
    spring.datasource.username=Usuario
    spring.datasource.password=Contraseña
```

- Establecer la versión 11 del jdk de java para correr la aplicación
- Ejecutar la aplicacion
- Visitar la pagina http://localhost:8080/swagger-ui/index.html para visualizar la UI de Swagger


