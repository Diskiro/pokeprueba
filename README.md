# PokeAPI Fullstack Project

Este proyecto contiene una API REST en Spring Boot y un frontend en Angular para consultar información de Pokémon.

## Estructura del proyecto

```
prueba-api-rest/
├── frontend/
│   └── pokeapp/        # Aplicación Angular
│       ├── src/
│       ├── node_modules/
│       ├── angular.json
│       └── ...
├── pokeapi-spring/     # API REST en Spring Boot
│   ├── src/
│   ├── target/
│   ├── pom.xml
│   └── ...
└── .gitignore
```

## Requisitos
- Node.js >= 18
- Java >= 17
- Maven

## Instalación y ejecución

### Backend (Spring Boot)
1. Ve a la carpeta `pokeapi-spring`:
   ```sh
   cd pokeapi-spring
   ```
2. Compila y ejecuta:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
   Para revisar el api con swagger esta disponible en `http://localhost:8080/swagger-ui.html`.


### Frontend (Angular)
1. Ve a la carpeta `frontend/pokeapp`:
   ```sh
   cd frontend/pokeapp
   ```
2. Instala dependencias:
   ```sh
   npm install
   ```
3. Ejecuta la app:
   ```sh
   npm start
   ```
   El frontend estará disponible en `http://localhost:4200` (o el puerto configurado).

## Configuración CORS
Si tienes problemas de CORS, asegúrate de que el backend permita peticiones desde el origen del frontend. Puedes agregar en tu controlador:
```java
@CrossOrigin(origins = "http://localhost:4200")
```
O configurar CORS globalmente en Spring Boot.

## Notas
- El archivo `.gitignore` excluye carpetas de dependencias, builds y archivos temporales.
- Puedes personalizar la política CSP en `frontend/pokeapp/src/index.html` según tus necesidades de seguridad.

## Autor
- Joshua Andrade

## Tiempo
- tiempo para hacer el proyecto Backend: 3 horas Frontend: 3 horas 
