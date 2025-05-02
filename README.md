# Inventory Management System

A backend system developed with Java and Spring Boot to manage inventory for small businesses. It provides full CRUD functionality for products, categories, and suppliers, along with additional features like low-stock alerts and product filtering.

## 🧩 Features

- CRUD operations for:
  - Products
  - Categories
  - Suppliers
- Product filtering by category.
- Sorting products by price.
- Low-stock detection.
- Entity relationships:
  - `Product` ⟶ `Category` (ManyToOne)
  - `Product` ⟶ `Supplier` (ManyToOne)
- Clean code architecture with DTOs and service layer

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- Maven



