##Product Service project for an ecomm platform##

1. Description:<br>
   The ProductService project is a microservice designed to manage product catalog operations within an E-commerce ecosystem. It provides RESTful APIs for product creation, retrieval, updating, and deletion, forming the backbone of catalog management in a distributed architecture. This repository is part of a larger thesis project exploring scalable microservices for modern E-commerce platforms.
   
3. Objectives:<br>
   a.	Centralized Product Management Provide a unified service for handling product data across multiple applications and industries.<br>
   b.	Scalability & Flexibility Utilize Spring Boot’s microservice architecture to support distributed deployments and             cloud-native environments.<br>
   c.	Database Integration Ensure reliable storage and retrieval of product information using JPA/Hibernate with relational       databases.<br>
   d.	Interoperability Offer RESTful APIs that can be consumed by diverse systems, enabling seamless integration.<br>
   e.	Operational Efficiency Automate catalog workflows, reduce manual errors, and enable real-time synchronization of             product data.<br>

4. Features:<br>
   CRUD Operations: Create, Read, Update, Delete products.<br>

   RESTful API Endpoints: JSON-based communication for interoperability.<br>

   Database Integration: Likely using MySQL/PostgreSQL (adapt based on repo).<br>

   Scalability: Designed to be deployed independently in a microservice ecosystem.<br>

   Error Handling: Structured exception responses for robustness.<br>

   Service Discovery : Smooth Interservices communication handled using Eureka library.<br>

   Event Driven Communivcation acheived using Kafka.<br>

   Extensibility: Can be integrated with services like OrderService, InventoryService, and PaymentService.<br>
   
5. Tech Stack:<br>
Spring Boot	--> Build REST APIs & microservices<br>
MySQL	Store --> product catalog data<br>
Kafka	--> Event-driven communication<br>
Eureka --> Service discovery & registry<br>
AWS Cloud --> 	Deployment & scaling<br>
RDS -->	Managed relational database<br>
Elastic Cache -->	Caching search results<br>

6. Installation and set up : <br>
   a. Java and Maven should be installed on the system.<br>
   b. An IDE like Intellij or Eclispe should be installed.<br>
   c. Clone the repo : git clone https://github.com/Mohit7892/ProductService.git<br>
   d. Configure DB : Update application.properties with DB credentials.<br>
     eg. spring.datasource.url=jdbc:mysql://localhost:3306/productdb<br>
         spring.datasource.username=root<br>
         spring.datasource.password=<yourpassword><br>
    e. Build and Run : <br>mvn clean install<br>
                       mvn spring-boot:run<br>


7. API Endpoints :<<br> Base URL --> http://localhost:8080<br>

| Method | Endpoint                      | Description                            |
| ---    | ---                           | ---                                    |
| GET    | /products                     | Fetch all products                     |
| GET    | /products/{productId}         | Fetch product by ID                    |
| POST   | /products                     | Add new product                        |
| PUT    | /products/{id}                | Update product details                 |
| DELETE | /products/{productId}         | Remove product                         |
| GET    |/products/{productId}/{userId} |Fetch product by product id and user id |

Author: <br>
Mohit Kumar Raghav<br>
Scaler Neovarsity Learner<br>
