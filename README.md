# Quiz Application using Monolithic Architecture

This is a Quiz Application built using a Monolithic Architecture. The application allows users to take quizzes on various topics and provides functionality for managing quizzes and questions.

## Features

- Create, read, update, and delete quizzes
- Add questions to quizzes
- Submit quiz responses and calculate results
- View quiz results

## Technologies Used

- Java
- Spring Boot
- Hibernate
- MySQL
- Lombok

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL

### Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-username/Quiz-Application-using-Monolothic-Architecture.git
   cd Quiz-Application-using-Monolothic-Architecture

Configure the database:

Update the application.properties file with your MySQL database configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/questiondb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


Build the project:

mvn clean install

Run the application:

mvn spring-boot:run



##Usage
Access the application:

Open your web browser and go to http://localhost:8080.

API Endpoints:

GET /get/{id}: Get a quiz by ID
POST /submit/{id}: Submit quiz responses
DELETE /deletequiz/{id}: Delete a quiz by ID


Example JSON for Questions
Here is an example JSON array for creating questions in the category of Python:

[
    {
        "id": 1,
        "questionTitle": "What is the purpose of the 'with' statement in Python?",
        "option1": "To create a temporary variable that can be used within a block of code",
        "option2": "To create a context manager that can be used to manage resources",
        "option3": "To create a generator that can be used to iterate over a sequence",
        "option4": "None of the above",
        "rightAnswer": "To create a context manager that can be used to manage resources",
        "difficultyLevel": "Easy",
        "category": "Python"
    },
    {
        "id": 2,
        "questionTitle": "What is the difference between 'is' and '==' operators in Python?",
        "option1": "'is' operator checks for reference equality, '==' operator checks for value equality",
        "option2": "'is' operator checks for value equality, '==' operator checks for reference equality",
        "option3": "'is' and '==' operators are same",
        "option4": "None of the above",
        "rightAnswer": "'is' operator checks for reference equality, '==' operator checks for value equality",
        "difficultyLevel": "Medium",
        "category": "Python"
    },
    {
        "id": 3,
        "questionTitle": "What is the purpose of the 'try-except' block in Python?",
        "option1": "To handle exceptions that may occur during the execution of a block of code",
        "option2": "To skip the execution of a block of code when an exception occurs",
        "option3": "To terminate the program when an exception occurs",
        "option4": "None of the above",
        "rightAnswer": "To handle exceptions that may occur during the execution of a block of code",
        "difficultyLevel": "Easy",
        "category": "Python"
    },
    {
        "id": 4,
        "questionTitle": "What is the purpose of the 'yield' keyword in Python?",
        "option1": "To return a value from a function",
        "option2": "To create a generator that can be used to iterate over a sequence",
        "option3": "To raise an exception",
        "option4": "None of the above",
        "rightAnswer": "To create a generator that can be used to iterate over a sequence",
        "difficultyLevel": "Medium",
        "category": "Python"
    },
    {
        "id": 5,
        "questionTitle": "What is the purpose of the 'lambda' keyword in Python?",
        "option1": "To define a new class",
        "option2": "To define an anonymous function",
        "option3": "To define a new module",
        "option4": "None of the above",
        "rightAnswer": "To define an anonymous function",
        "difficultyLevel": "Easy",
        "category": "Python"
    }
]




License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
Thanks to the Spring Boot and Hibernate communities for their excellent documentation and support.
