# Polls Backend Application

## Overview

This is a Spring Boot application for managing polls and votes. It provides RESTful APIs for creating polls, submitting votes, and retrieving poll results. The application uses MongoDB as its database to store polls and votes.

## Features

- **Poll Management**: Create, update, and retrieve polls.
- **Vote Submission**: Submit votes to polls and retrieve votes for specific polls.
- **MongoDB Integration**: Uses MongoDB to store poll and vote data.

## Technology Stack

- **Java 17**
- **Spring Boot 3.3.2**
- **Spring Data MongoDB**
- **JUnit** and **Mockito** for testing
- **Maven** for build management
- **MongoDB** for the database

## Installation

### Prerequisites

- **Java 17**: Make sure JDK 17 is installed.
- **Maven**: Ensure Maven is installed for building the project.
- **MongoDB**: Make sure MongoDB is installed and running on your local machine. MongoDB Community Server Download: https://www.mongodb.com/try/download/community

### Clone the Repository

```bash
git clone https://github.com/bsarna89/Polls.git
cd polls-back-end
```

### Build the Project

```bash
mvn clean install
```

### Database Setup
#### Import or Create a Database with Sample Data
1. Make sure MongoDB is installed and running on your machine. You can start MongoDB by running:
```bash
mongod
```
2. Create a New Database and Collection
3. Use the MongoDB shell or a tool like MongoDB Compass to create a new database (e.g., pollsDb) and a collection (e.g., polls, votes).
4. Insert Sample Data:

- You can insert sample data using MongoDB Compass or directly from the MongoDB shell
- You may import from this rpeository:  "polls-back-end\src\main\java\polls_back_end\Db"

5. Sample Data:

- Poll 
```bash
{
  "active": true,
  "totalVotes": 0,
  "question": "Your Question",
  "options": [
    {
      "text": "Option1"
    },
    {
      "text": "Option2"
    },
  ]
}
```
- Vote
```bash
{
  "pollId": "Specific Poll Id",
  "optionText": "Chosen Option"
}
```

### Run the Application
```bash
mvn spring-boot:run
```
### Running the Application from Different IDEs
- VS Code: https://code.visualstudio.com/docs/java/java-spring-boot
- IntelliJ IDEA: https://www.jetbrains.com/help/idea/spring-boot.html
- Eclipse: https://www.eclipse.org/community/eclipse_newsletter/2018/february/springboot.php


## API Endpoints
### Polls
- GET /api/polls: Retrieve all polls.
- POST /api/polls: Create a new poll.
- GET /api/polls/{pollId}: Retrieve a poll by its ID.
- PUT /api/polls/{pollId}: Update a poll by its ID.
### Votes
- GET /api/votes/poll/{pollId}: Retrieve all votes for a specific poll.
- POST /api/votes: Submit a vote for a poll.


## Running Tests
### Unit Tests
- To run unit tests, use the following Maven command:
```bash
mvn test
```
This will execute the unit tests for services, controllers, and the application context.

### Component Tests
- Postman
- HTTPie
- Insomnia

##  Further Considerations

### Security

- **Authentication and Authorization** 
- **CSRF Protection**
- **HTTPS**
- **Input Sanitization**
- **Security Headers**

### Caching with Redis

- **Integrating Redis**
- **Spring Cache Abstraction**

### Error Handling
- **Global Exception Handling**
- **Custom Error Responses**

### Validation
- **Input Validation**
- **Custom Validators** 