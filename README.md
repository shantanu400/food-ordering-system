# Food Ordering System — Low Level Design (LLD)

## Overview
A production-style **Low Level Design (LLD)** implementation of an in-memory **Food Ordering System** in Java.
This project focuses on clean domain modeling, layered architecture, and extensible business logic using **SOLID principles** and the **Strategy Design Pattern**.

The goal of this project is to demonstrate how real-world backend systems are designed at the object level rather than just implementing CRUD logic.

---

## Key Features
- Restaurant onboarding with menu, rating, and order capacity
- Menu management (add and update items; no deletions)
- Order placement with item quantities
- Automatic restaurant assignment using **pluggable selection strategies**:
    - Lowest Bill Cost
    - Highest Rating
- Restaurant capacity enforcement for concurrent orders
- Order lifecycle handling:
  `PLACED → ACCEPTED → COMPLETED`
- Fully in-memory implementation (no database)

---

## Design & Architecture Highlights
- **Layered Architecture**
    - Controller → Service → Repository → Entity
- **Strategy Pattern**
    - Clean separation of restaurant selection logic
    - Easy to extend with new strategies without modifying core flow
- **Strong Encapsulation**
    - Business rules enforced inside domain entities
    - Order state transitions guarded by invariants
- **SOLID Principles**
    - SRP: Clear separation of responsibilities
    - OCP: New strategies can be added without code changes
    - DIP: Services depend on abstractions, not implementations

---

## Tech Stack
- Java
- Object-Oriented Programming (OOP)
- SOLID Design Principles
- Strategy Design Pattern
- In-memory data structures

---

## How to Run
Run the `Main` class to execute a complete demo flow:
- Initialize menus and restaurants
- Update menu items
- Place orders using different selection strategies
- View assigned restaurants and order details

---

## Why This Project?
This project is intentionally designed as an **LLD-focused exercise**, making it ideal for:
- Backend / Java interviews
- System design discussions
- Demonstrating clean architecture and design patterns
