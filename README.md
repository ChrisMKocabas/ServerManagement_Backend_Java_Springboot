# Server Management System Backend

## Description

The project is a Java Spring Boot backend that serves as the backend for an Angular frontend. It provides functionalities related to managing servers and performing server-related operations. The backend is responsible for handling server data, communication with the database, and exposing RESTful API endpoints for the frontend to interact with.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)

## Installation

To set up the project locally, follow these steps:

1. Clone the repository to your local machine.
2. Make sure you have Java Development Kit (JDK) installed. If not, download and install the latest version of JDK.
3. Install Apache Maven build tool.
4. Set up a database (e.g., MySQL) and create the necessary tables.
5. Update the database connection details in the `application.properties` file.
6. Build the project using Maven by running the command: `mvn clean install`.
7. Start the backend server using the command: `mvn spring-boot:run`.

## Usage

Once the backend server is up and running, you can use the following guidelines to interact with the project:

1. Access the frontend application by opening the provided URL in a web browser.
2. Use the frontend interface to perform server-related operations such as creating servers, listing servers, pinging servers, etc.
3. The backend will handle the requests from the frontend and process the corresponding operations.
4. The frontend will display the results and provide a user-friendly interface for managing servers.

## API Documentation

The backend provides the following API endpoints:

- `GET /server/list/{limit}`: Retrieves a list of servers with an optional limit parameter.
- `GET /server/ping/{ipAddress}`: Pings a server with the specified IP address and retrieves the server's status.
- `POST /server/save`: Creates a new server with the provided server data.
- `GET /server/get/{id}`: Retrieves the details of a server with the specified ID.
- `DELETE /server/delete/{id}`: Deletes the server with the specified ID.
- `GET /server/image/{fileName}`: Retrieves the server image with the specified file name.

For detailed API documentation, refer to the [API documentation file](./API_DOCUMENTATION.md).

## Development

To contribute to the project, follow these guidelines:

1. Fork the repository and clone it to your local machine.
2. Set up the development environment with the required tools and dependencies.
3. Make changes or additions to the codebase according to the project requirements.
4. Run tests to ensure that your changes are functioning correctly.
5. Commit your changes and push them to your forked repository.
6. Submit a pull request to the main repository, describing your changes and the problem they solve.

### Backend Development

To set up the backend development environment:

1. Make sure you have Java Development Kit (JDK) and Apache Maven installed.
2. Set up a database (e.g., MySQL) and configure the database connection details in the `application.properties` file.
3. Use an Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse to open the backend project.
4. Install any required dependencies using Maven.
5. Write your code in the appropriate classes and packages, following the project's coding style and guidelines.
6. Run tests to ensure your changes do not introduce any regressions or errors.
7. Build and run the backend application locally for testing and debugging purposes.

### Frontend Development

To set up the frontend development environment:

1. Make sure you have Node.js and npm (Node Package Manager) installed.
2. Use a code editor (e.g., Visual Studio Code) to open the frontend project.
3. Install the project dependencies by running the command: `npm install`.
4. Write your code in the appropriate components and modules, following the project's coding style and guidelines.
5. Run the frontend application locally using the command: `ng serve`.
6. Access the application in your browser at the provided URL for testing and debugging purposes.

## Contributing

Contributions to the project are welcome. If you encounter any issues, have suggestions, or want to contribute new features, please follow these steps:

1. Fork the repository and clone it to your local machine.
2. Create a new branch for your feature or bug fix.
3. Make your changes, following the project's coding style and guidelines.
4. Run tests to ensure your changes do not introduce any regressions or errors.
5. Commit your changes with a descriptive commit message.
6. Push your changes to your forked repository.
7. Submit a pull request to the main repository, describing your changes and the problem they solve.

Please make sure to adhere to the coding standards, write unit tests for your code, and provide any necessary documentation or updates to existing documentation.

## License

The project is licensed under the [MIT License](./LICENSE).
