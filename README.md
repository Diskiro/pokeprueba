# PokeAPI Fullstack Project

Este proyecto contiene una API REST en Spring Boot y un frontend en Angular para consultar información de Pokémon.

## Estructura del proyecto

```
prueba-api-rest/
├── pokeapi-spring/     # API REST en Spring Boot
│   ├── src/
│   ├── target/
│   ├── pom.xml
│   └── ...
└── .gitignore
```

## Requisitos
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


## Notas
- El archivo `.gitignore` excluye carpetas de dependencias, builds y archivos temporales.

## Autor
- Joshua Andrade

## Tiempo
- tiempo para hacer el proyecto Backend: 3 horas Frontend: 3 horas 
