##Product Service project for an ecomm platform##

1. Description:
   The ProductService project is a microservice designed to manage product catalog operations within an E-commerce ecosystem. It provides RESTful APIs for product creation, retrieval, updating, and deletion, forming the backbone of catalog management in a distributed architecture. This repository is part of a larger thesis project exploring scalable microservices for modern E-commerce platforms.
   
3. Objectives:
   a.	Centralized Product Management Provide a unified service for handling product data across multiple applications and industries.
   b.	Scalability & Flexibility Utilize Spring Boot’s microservice architecture to support distributed deployments and             cloud-native environments.
   c.	Database Integration Ensure reliable storage and retrieval of product information using JPA/Hibernate with relational       databases.
   d.	Interoperability Offer RESTful APIs that can be consumed by diverse systems, enabling seamless integration.
   e.	Operational Efficiency Automate catalog workflows, reduce manual errors, and enable real-time synchronization of             product data.

4. Features:
   CRUD Operations: Create, Read, Update, Delete products.

   RESTful API Endpoints: JSON-based communication for interoperability.

   Database Integration: Likely using MySQL/PostgreSQL (adapt based on repo).

   Scalability: Designed to be deployed independently in a microservice ecosystem.

   Error Handling: Structured exception responses for robustness.

   Service Discovery : Smooth Interservices communication handled using Eureka library.

   Event Driven Communivcation acheived using Kafka.

   Extensibility: Can be integrated with services like OrderService, InventoryService, and PaymentService.
   
5. Tech Stack:
Spring Boot	--> Build REST APIs & microservices
MySQL	Store --> product catalog data
Kafka	--> Event-driven communication
Eureka --> Service discovery & registry
AWS Cloud --> 	Deployment & scaling
RDS -->	Managed relational database
Elastic Cache -->	Caching search results

6. Installation and set up : 
   a. Java and Maven should be installed on the system.
   b. An IDE like Intellij or Eclispe should be installed.
   c. Clone the repo : git clone https://github.com/Mohit7892/ProductService.git
   d. Configure DB : Update application.properties with DB credentials.
     eg. spring.datasource.url=jdbc:mysql://localhost:3306/productdb
         spring.datasource.username=root
         spring.datasource.password=<yourpassword>
    e. Build and Run : mvn clean install
                       mvn spring-boot:run


7. API Endpoints : Base URL --> http://localhost:8080

| Method | Endpoint                      | Description                            |
| ---    | ---                           | ---                                    |
| GET    | /products                     | Fetch all products                     |
| GET    | /products/{productId}         | Fetch product by ID                    |
| POST   | /products                     | Add new product                        |
| PUT    | /products/{id}                | Update product details                 |
| DELETE | /products/{productId}         | Remove product                         |
| GET    |/products/{productId}/{userId} |Fetch product by product id and user id |

Author: 
Mohit Kumar Raghav
Scaler Neovarsity Learner
