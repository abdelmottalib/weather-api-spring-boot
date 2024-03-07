# Weather App using Spring Boot

## Overview
This Spring Boot application provides a simple interface to display the current weather information using a third-party API. Users can input the name of a city, and the application fetches real-time weather data from the external API to present relevant details.

## Features
- **City-based Weather:** Users can enter the name of a city to get the current weather information.
- **Third-Party API Integration:** The app leverages two third-party APIS, one that fetches the geolocation, and another that uses the geolocation to get the current weather.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) installed.
- Maven installed.

### Setup
1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/weather-app.git
    ```
2. **Navigate to the project directory:**
    ```bash
    cd weather-app
    ```
3. **Build the project:**
    ```bash
    mvn clean install
    ```
4. **Run the application:**
    ```bash
    java -jar target/weather-app.jar
    ```
5. **Access the app in your web browser at http://localhost:8080.**

### Configuration
- **API Key:** To use the third-party API, obtain an API key and configure it in the `application.properties` file.
    ```properties
    weather.api.key=your-api-key
    ```

