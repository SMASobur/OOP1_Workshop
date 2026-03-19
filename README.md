# Workshop: OOP 1 – Online Shop System

##  Project Overview
This project simulates a simplified online store to demonstrate fundamental **Object-Oriented Programming (OOP)** concepts in Java. The focus is on **Encapsulation** and **Unidirectional Relationships** between Customers, Products, and Orders.

The system calculates the total price of an order by summing the prices of all associated products while maintaining strict data integrity through private fields and validation logic.

---

##  Core Features
*   **Encapsulation**: All fields are `private`. Access is managed via getters and setters with validation (e.g., preventing negative prices or empty names).
*   **Object Relationships**:
    *   **Order → Customer**: Each order belongs to exactly one customer.
    *   **Order → Product**: Each order contains a collection (List) of one or more products.
*   **Unidirectional Design**: The `Order` class knows about its `Customer` and `Products`, but `Customer` and `Product` remain independent of the `Order`.
*   **Business Logic**: The `Order` class is responsible for calculating the total value of the purchase.

---

##  UML Class Diagram

```mermaid
classDiagram
    class Customer {
        -int customerId
        -String name
        -String email
        +getName() String
        +getCustomerInfo() String
    }

    class Product {
        -int productId
        -String name
        -double price
        +getPrice() double
        +getProductInfo() String
    }

    class Order {
        -int orderId
        -List~Product~ products
        -Customer customer
        +addProduct(Product p)
        +calculateTotal() double
        +displayOrder() void
    }

    Order "1" --> "1" Customer : belongsTo
    Order "1" o-- "*" Product : contains
