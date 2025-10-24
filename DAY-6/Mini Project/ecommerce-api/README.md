# E-Commerce API (Spring Boot)

Features:
- Customer, Product, Order management (CRUD + order lifecycle)
- MySQL storage (Docker Compose provided)
- JWT authentication (register + login)
- Built with Spring Boot, Spring Data JPA, Spring Security, jjwt

## How to run

1. Build the JAR:
   mvn clean package

2. Start MySQL via docker-compose:
   docker compose up -d

   (Docker Compose will start a MySQL container with user `appuser` / `apppass` and database `ecommerce`.)

3. Start the app:
   - Locally:
     java -jar target/ecommerce-api-0.0.1-SNAPSHOT.jar
   - Or via Docker (after building the image):
     docker build -t ecommerce-api .
     docker compose up -d

Environment variables:
- SPRING_DATASOURCE_URL (defaults to jdbc:mysql://localhost:3306/ecommerce?useSSL=false&serverTimezone=UTC)
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- JWT_SECRET (a long secret; default in properties is `changeitsecretkey`)

## API

- POST /api/auth/register  -> register user
- POST /api/auth/login     -> login (returns token)
- Use header `Authorization: Bearer <token>` for protected endpoints.

See source files for DTO shapes and example usage.

