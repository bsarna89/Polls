# Poll Voting App

This Poll Voting System is designed to work alongside graphics platform, allowing users to participate in active polls seamlessly. The application provides users with the ability to view currently active polls, cast their votes, and immediately see the voting results in real-time.

## Documentation & Instructions

- **System Design Document** for Java / SpringBoot and MongoDB database: [polls-back-end](polls-back-end/README.md)
- **System Design Document** for TypeScript / Vue with Cypress: [polls-front-end](polls-front-end/README.md)

## Features

- Active Poll Display: The system displays the currently active poll as soon as the user visits the website.
- Voting Mechanism: Users can select one of the available options to cast their vote.
- Real-Time Results: After voting, users are shown the vote percentage for each option in real-time, giving them instant feedback.

## Implemented Requirements

- **Flexible Poll Options**: Polls have been designed to accommodate between 2 and 7 options, ensuring versatility in poll creation.
- **Responsive Design**: The website is fully responsive, providing a seamless experience  screen sizes.
- **Database Integration**: Polls and votes are stored in a database.
- **API for Poll Creation**: An API endpoint has been developed to allow the creation of new polls programmatically, making it easy to manage polls from external systems.
- **API for Viewing Votes**: An API is available to retrieve individual votes for a given poll, along with the timestamp of when each vote was cast.
- **Testing Example Provided**: Examples of how to test both the front-end and back-end code have been included.


## Future Considerations

### Dockerize and Host the Application
- **Containerization**
- **Docker Compose**
- **Hosting**

### Enhance React Functionality
- **User Authentication & Authorization**
- **UI/UX Improvements**
- **Full Testing**

### Serverless Version
- **Serverless Architecture**
- **Cost Efficiency**
- **Simplified Deployment**
- **Scalability**
