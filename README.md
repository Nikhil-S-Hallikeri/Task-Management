# Task-Management
A robust RESTful API for a Task Management system built with Java and the Spring Boot framework. This backend service provides full CRUD (Create, Read, Update, Delete) functionality for managing tasks and includes business logic for automatically handling task statuses and completion remarks.


✨ Core Features
Full CRUD Functionality: Create, read, update, and delete tasks.
Automatic Status Management: Tasks are PENDING by default and can be marked as COMPLETED.
Smart Completion Remarks: When a task is completed, it's automatically marked as ON_TIME or LATE by comparing the completion date to the due date.
Input Validation: Ensures data integrity with server-side validation for creating and updating tasks.
Layered Architecture: Follows best practices with a clean separation of concerns into Controller, Service, and Repository layers.
In-Memory Database: Uses H2 for easy setup and development.


🛠️ Technology Stack
Java 17: The core programming language.
Spring Boot 3.2: The main application framework for building production-grade, standalone applications.
Spring Web: For building the RESTful API endpoints.
Spring Data JPA: For data persistence and simplifying database interactions.
Hibernate: The Object-Relational Mapping (ORM) provider.
H2 Database: An in-memory database, perfect for development and testing.
Maven: The build automation and dependency management tool.
Lombok: A library to reduce boilerplate code (getters, setters, etc.).
