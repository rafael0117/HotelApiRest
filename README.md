# HotelApiRest

API RESTful para la gestión de hoteles, desarrollada en Java con Spring Boot y Gradle.

## Descripción

HotelApiRest es una API backend que administra los procesos esenciales de un hotel: habitaciones, reservas, huéspedes y empleados. Implementa seguridad JWT para autenticación y sigue una arquitectura en capas (controladores, servicios, repositorios y DTOs).

## Tecnologías y dependencias principales

- **Lenguaje principal:** Java 17
- **Framework principal:** Spring Boot 3.5.3
- **Seguridad:** Spring Security con JWT (`io.jsonwebtoken`)
- **Persistencia:** Spring Data JPA
- **Base de datos:** MySQL (conector incluido)
- **Mapeo de objetos:** Uso de DTOs y mapeadores personalizados
- **Gestión de dependencias y build:** Gradle
- **Inyección de dependencias y utilidades:** Lombok
- **Testing:** JUnit, Spring Boot Test, Spring Security Test

### Dependencias principales (extracto de `build.gradle`)
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `spring-boot-starter-web`
- `org.projectlombok:lombok`
- `mysql:mysql-connector-j`
- `io.jsonwebtoken:jjwt-api`, `jjwt-impl`, `jjwt-jackson`
- `spring-boot-devtools`
- Pruebas: `spring-boot-starter-test`, `spring-security-test`, `junit-platform-launcher`

## Estructura del proyecto

```
HotelApiRest/
├── src/
│   ├── main/
│   │   └── java/com/rafael0117/HotelApp/
│   │       ├── application/
│   │       │   ├── dto/
│   │       │   ├── mapper/
│   │       │   └── service/
│   │       ├── domain/
│   │       │   ├── entity/
│   │       │   └── repository/
│   │       ├── security/
│   │       ├── web/
│   │       │   └── controller/
│   │       └── HotelAppApplication.java
│   └── test/
├── build.gradle
├── settings.gradle
└── README.md
```

## Principales módulos y funcionalidades

- **Endpoints RESTful** para habitaciones, reservas, huéspedes y empleados
- **Seguridad:**  
  - Filtros JWT y configuración personalizada en `SecurityConfig`
  - Endpoints públicos y privados protegidos por roles
- **Controladores:**  
  - `/api/habitacion`  
  - `/api/reserva`  
  - `/api/auth`
- **Servicios (ServiceImpl):**  
  - Lógica de negocio separada por capa de servicios
- **DTOs y Mappers:**  
  - Separación entre entidades y objetos de transferencia de datos

## Seguridad

- Autenticación con JWT (Json Web Token)
- Roles y permisos gestionados desde Spring Security
- CORS configurado para permitir solicitudes desde `http://localhost:4200` (ideal para frontend Angular)

## Instalación y ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/rafael0117/HotelApiRest.git
   ```
2. Compila el proyecto:
   ```bash
   ./gradlew build
   ```
3. Ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```
4. Accede a los endpoints desde tu cliente REST o frontend.

## Contribución

Las contribuciones son bienvenidas. Abre un issue o pull request para sugerencias y mejoras.

---

> _Actualiza este README con instrucciones específicas de despliegue, configuración de base de datos y ejemplos de endpoints cuando lo requieras._
