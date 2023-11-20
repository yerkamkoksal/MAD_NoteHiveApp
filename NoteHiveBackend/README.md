# README for NoteHive

NoteHive is an innovative Android calendar application that integrates note-taking and event management in one seamless interface. Built using Spring Boot for backend services, it provides a robust and responsive experience for managing your daily activities, notes, and events.

## Features

- **Calendar Management**: Create and manage dates with ease.
- **Note Integration**: Seamlessly integrate notes with calendar dates.
- **Event Tracking**: Add and track events.

## Installation

To set up the backend, ensure you have Java and Spring Boot installed.

1. Clone the repository.
2. Navigate to the project directory.
3. Run `Application.java` to start the Spring Boot application.

## Usage

After running the backend server:

- Open the Android app and connect to the server.
- Use the calendar interface to add, view, or edit dates.
- Attach notes to specific dates for detailed reminders.
- Create and manage events through the easy-to-use interface.

## Backend Structure

- `Application.java`: Initializes the Spring Boot application.
- `NoteHiveRestController.java`: Handles REST API requests.
- `Calendar.java`, `Notes.java`, `Event.java`: Define the data models.
- `CalendarService.java`, `EventService.java`: Services for business logic.
- `EventRepo.java`, `CalendarRepo.java`, `NoteRepo.java`: Interfaces for database operations.

## Contributing

Contributions to improve NoteHive are welcome. Please follow these steps:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Your Name - yusuferkamkoksal@outlook.com

Project Link: [https://github.com/yerkamkoksal/NoteHive](https://github.com/yerkamkoksal/NoteHive)
