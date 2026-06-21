
#  STILL IN PROGRESS 

# springboot-ecommerce-microservices
A complete Spring Boot eCommerce Backend project covering REST APIs, JPA, Hibernate, PostgreSQL, Docker, Actuator, and Microservices Architecture.
# Spring Boot Ecommerce Microservices

## 📌 Project Overview

This project demonstrates the development of a complete Ecommerce Backend using Spring Boot. The application starts as a monolithic architecture and is later migrated into Microservices.

The project covers:

* REST API Development
* Service Layer Architecture
* Spring Data JPA
* Hibernate ORM
* H2 Database
* PostgreSQL
* DTO Pattern
* Entity Relationships
* Cart Management
* Order Processing
* Spring Boot Actuator
* Docker & Docker Compose
* Microservices Architecture
* API Gateway

---

## 🚀 Features

### User Management

* Create User
* Update User
* Fetch User
* Fetch All Users

### Product Management

* Create Product
* Update Product
* Delete Product
* Fetch Products

### Cart Management

* Add to Cart
* Remove from Cart
* View Cart

### Order Management

* Place Order
* View Orders

### Monitoring

* Health Endpoint
* Metrics Endpoint
* Logger Endpoint
* Beans Endpoint

### Deployment

* Docker Containerization
* PostgreSQL Integration
* Docker Compose Setup

---

## 🛠 Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* PostgreSQL
* Docker
* Docker Compose
* Maven

---

## 📂 Project Structure

user-service/
product-service/
order-service/
api-gateway/

---

## ▶️ Run Project

Clone Repository

```bash
git clone <repository-url>
```

Navigate to Project

```bash
cd springboot-ecommerce-microservices
```

Build Project

```bash
mvn clean install
```

Run Application

```bash
mvn spring-boot:run
```

---

## 🐳 Docker Setup

Build Docker Image

```bash
docker build -t ecommerce-app .
```

Run Container

```bash
docker run -p 8080:8080 ecommerce-app
```

Run Docker Compose

```bash
docker-compose up -d
```

---

## 📈 Future Enhancements

* JWT Authentication
* Spring Security
* Service Discovery
* Config Server
* Kafka Integration
* CI/CD Pipeline
* Kubernetes Deployment


 this project useful, please give it a star on GitHub.
