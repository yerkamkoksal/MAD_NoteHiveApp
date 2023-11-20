# README for NoteHive Android Application

## Overview
NoteHive is an Android-based calendar application, designed to streamline the management of daily activities, events, and notes. The backend of the application is built using Spring Boot, Spring Web, and Java.

## Features
- **Activity Tracking:** Users can add, view, and manage various activities and events.
- **Note Management:** Facilitates creating, editing, and organizing personal notes.
- **Interactive Calendar:** A user-friendly interface to view activities scheduled on specific dates.
- **Event Descriptions:** Each event can be detailed with comprehensive descriptions and relevant data.

## Technical Stack
- **Frontend:** Android Studio
- **Backend:** Spring Boot, Spring Web
- **Language:** Java

## Main Components
### Backend
- `Application.java`: Entry point of the Spring Boot application.
- `NoteHiveRestController.java`: REST controller for handling HTTP requests.
- `CalendarService.java`, `EventService.java`: Services providing business logic for calendar and events.
- `CalendarRepo.java`, `EventRepo.java`, `NoteRepo.java`: Repositories for data persistence.

### Android Studio (Frontend)
- `ActivitiesAdapter.java`: Adapter for handling activities display.
- `ActivityDescriptionActivity.java`: Activity for displaying detailed descriptions of events.
- `AddEventActivity.java`: Interface to add new events.
- `HomePageActivity.java`: The main activity serving as the homepage.
- `ViewActivitiesActivity.java`: Activity to view and manage scheduled activities.

## Setup and Installation
Ensure that you have Android Studio installed for running the frontend application. For the backend, Java SDK and Spring Boot are required.

## Usage
To use the application:
1. Start the Spring Boot application.
2. Run the Android Studio project.
3. Navigate through the app to add, view, or manage activities and notes.

## Contributing
Contributions to NoteHive are welcome. Please feel free to fork the repository, make changes, and create a pull request.

## Contact
- Email: yusuferkamkoksal@outlook.com
- GitHub: [yerkamkoksal](https://github.com/yerkamkoksal)

## License
NoteHive is open-sourced under the [MIT License](https://opensource.org/licenses/MIT).