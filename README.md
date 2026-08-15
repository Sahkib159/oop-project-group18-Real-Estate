# Real Estate Management System — OOP Project (Group 18)

## Overview
This repository contains the final project for our Object-Oriented Programming (OOP) coursework. The application is a comprehensive Real Estate Management System designed to simulate the interactions between property buyers, sellers, and administrators. 

The project demonstrates core OOP principles—including inheritance, polymorphism, encapsulation, and abstraction—while providing a responsive graphical user interface for seamless property management and transactions.

## Key Features
* **Role-Based Access Control:** Secure login and dashboard routing for different user types (Admin, Buyer, Seller, Real Estate Agent).
* **Property Listing Management:** Sellers and agents can add, edit, or remove property listings with details such as price, location, and square footage.
* **Search & Filter Operations:** Buyers can search for available properties based on dynamic criteria.
* **Transaction Simulation:** Users can make offers, and agents can approve or decline property transactions.
* **Data Persistence:** File handling and object serialization to save user profiles and property states across sessions.

## Tech Stack & Development Tools
| Component | Technology | Description |
| :--- | :--- | :--- |
| **Language** | Java (JDK 21) | Core application logic and OOP implementation. |
| **GUI Framework** | JavaFX | Scene Builder and FXML for designing the interactive user interface. |
| **Build Tool** | Maven | Dependency management and project building. |
| **IDE** | IntelliJ IDEA | Primary development environment. |
| **Version Control** | GitHub | Collaborative development, branch management, and source control. |

## Core OOP Concepts Applied
1. **Encapsulation:** All model classes (e.g., `User`, `Property`, `Transaction`) use private fields with public getter and setter methods to protect data integrity.
2. **Inheritance:** A base `User` class is extended by `Admin`, `Buyer`, and `Seller` classes to inherit common attributes while implementing specific behaviors.
3. **Polymorphism:** Method overriding is utilized for dynamic dashboard rendering and role-specific dashboard actions.
4. **Abstraction:** Interfaces and abstract classes are used to define standard behaviors for property transactions and database operations.

## Local Setup Instructions
To run this project locally on your machine, follow these steps:

**1. Clone the repository**
`git clone https://github.com/Sahkib159/oop-project-group18-Real-Estate.git`

**2. Open the project**
Import the cloned directory into IntelliJ IDEA as a Maven project.

**3. Load Dependencies**
Allow Maven to automatically download the required JavaFX dependencies via the `pom.xml` file.

**4. Run the Application**
Locate the `Main.java` file (containing the JavaFX `start` method) and execute it to launch the login window.
