# Spring Boot Demo Application

A simple Spring Boot demo application with REST API, JPA/Hibernate, and H2 database.

## Features
- RESTful API endpoints
- JPA/Hibernate with H2 in-memory database
- CRUD operations for products
- Sample data initialization
- H2 console for database management

## Project Structure
```
src/main/java/com/example/demo/
├── DemoApplication.java          # Main application class
├── config/
│   └── DataInitializer.java     # Sample data initialization
├── controller/
│   ├── HelloController.java     # Simple greeting endpoints
│   └── ProductController.java   # Product CRUD endpoints
├── model/
│   └── Product.java             # Product entity
├── repository/
│   └── ProductRepository.java   # JPA repository
└── service/
    └── ProductService.java      # Business logic layer
```

## API Endpoints

### Hello Endpoints
- `GET /api/hello` - Simple greeting
- `GET /api/greet` - JSON greeting

### Product Endpoints
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Build and Run
```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run
```

### Access the Application
- Application: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console
  - JDBC URL: jdbc:h2:mem:testdb
  - Username: sa
  - Password: (leave empty)

### Test the API
```bash
# Get all products
curl http://localhost:8080/api/products

# Get product by ID
curl http://localhost:8080/api/products/1

# Create new product
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Tablet","description":"Latest tablet","price":499.99}'

# Update product
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Updated Laptop","description":"Updated description","price":1099.99}'

# Delete product
curl -X DELETE http://localhost:8080/api/products/1
```

## Technologies Used
- Spring Boot 3.2.0
- Spring Web (REST API)
- Spring Data JPA
- H2 Database
- Maven