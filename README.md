## Tour de France

Proyecto backend API Rest usando:
* Arquitectura limpia (Arquetipo de Bancolombia)
* Java(Gradle) - Spring webflux
* MongoDB

## Modulos - Backend
+ Application: Configuration, MainApplication
+ Deployment: Docker
+ Domain: Model, UseCase
+ Infrastructure: Driven-adapters, Entry-points

## Instrucciones para ejecutar el programa
1. Clone el repositorio
+ git clone https://github.com/luisortega95/tourDeFrance.git

2. Abra el proyecto en IntelliJ Idea


3. Dirijase al siguiente modulo para ejecutar la aplicación:

+ backend/applications/src/main/java
+ Run 'MainApplication'

4. Dirijase a Postman para consumir las siguentes rutas del API.


## Rutas

### Ciclista
+ GET http://localhost:8080/api/cyclist/{id}
+ GET("http://localhost:8080/api/cyclists
+ GET("http://localhost:8080/api/cyclist/country/{country}
+ GET("http://localhost:8080/api/cyclist/team/{code}
+ POST http://localhost:8080/api/cyclist
+ PUT("http://localhost:8080/api/cyclist/{id}
+ DELETE("http://localhost:8080/api/cyclist/{id}


### Equipo de ciclismo
+ GET http://localhost:8080/api/cycling-team/{id}
+ GET http://localhost:8080/api/cycling-teams
+ GET http://localhost:8080/api/cycling-team/code/{code}
+ GET http://localhost:8080/api/cycling-team/country/{country}
+ POST http://localhost:8080/api/cycling-team)
+ PUT http://localhost:8080/api/cycling-team/{id}
+ DELETE http://localhost:8080/api/cycling-team/{id}


### Desarrollador
+ Luis Ricardo Ortega