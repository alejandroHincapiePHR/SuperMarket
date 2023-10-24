# Supermarket Application

This is a Supermarket application built in Java using the Spring framework, Lombok, and MySQL database, with a Hexagonal architecture. 

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Why Hexagonal Architecture](#why-hexagonal-architecture)
- [Benefits](#benefits)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This Supermarket application is designed to provide a modern and efficient way to manage the operations of a supermarket, including inventory management, sales processing, and customer management. It leverages Java, the Spring framework, Lombok, and MySQL to deliver a robust, scalable, and maintainable solution.

## Project Structure

The project is organized using a Hexagonal architecture, also known as Ports and Adapters. The key components include:

- `core`: Contains the domain logic of the application, including entities, services, and business rules.
- `adapters`: Houses the inbound and outbound adapters for connecting the core to the external world. These adapters include REST API controllers, database repositories, and messaging.
- `application`: Serves as the application layer that orchestrates the flow of data and logic between the core and the adapters.

```
supermarket-app/
│
├── core/
│   ├── src/
│   └── pom.xml
│
├── adapters/
│   ├── src/
│   └── pom.xml
│
├── application/
│   ├── src/
│   └── pom.xml
│
├── pom.xml
├── README.md
├── .gitignore
```

## Why Hexagonal Architecture

The Hexagonal architecture, also known as Ports and Adapters, is chosen for this project due to several reasons:

1. **Modularity**: Hexagonal architecture promotes clear separation of concerns, making it easier to understand and maintain the codebase.

2. **Testability**: The architecture naturally lends itself to unit testing and isolation of components, allowing for comprehensive and effective testing.

3. **Adaptability**: Adapters (e.g., REST API, database) can be easily replaced or extended without affecting the core business logic.

4. **Scalability**: The architecture is well-suited for scaling the application horizontally by adding new adapters or services as the application grows.

5. **Maintenance**: It reduces the risk of tight coupling, making it easier to evolve and maintain the application over time.

## Benefits

The benefits of using Hexagonal architecture in this Supermarket application include:

- **Simplified Testing**: With clear separation of concerns, unit testing and mocking are easier to implement, ensuring a higher quality and more reliable codebase.

- **Extensibility**: The ability to add new features or adaptors without disturbing existing code allows for quick and efficient expansion of the application.

- **Enhanced Maintainability**: Separation of concerns and well-defined interfaces make it easier to understand and maintain the codebase over time.

- **Reduced Technical Debt**: The architecture mitigates technical debt by avoiding tightly coupled components, leading to a more stable and manageable system.

## Getting Started

To get started with this Supermarket application, follow these steps:

1. Clone this repository to your local machine.
2. Build and run the application using your preferred Java development environment.
3. Access the API documentation to learn about available endpoints and how to interact with the application.

Detailed instructions for setting up the development environment, running tests, and deploying the application can be found in the project's documentation.

## Contributing

If you'd like to contribute to this project, please check the [CONTRIBUTING.md](CONTRIBUTING.md) file for guidelines.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

We hope this README helps you understand the structure and rationale behind this Supermarket application. If you have any questions or would like to contribute, please feel free to get in touch.
