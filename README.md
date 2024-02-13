# Project Manager

## Prerequisites

Make sure you have the following prerequisites installed on your machine before running the project:

- **Java Development Kit (JDK):** Version 21 or later.
  - Download and install the JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://adoptopenjdk.net/).

## Project Structure

- `src/`: Contains the source code organized in packages (`application`, `database`, `util`, `view`).
- `resources/`: Contains non-Java resources like images.
- `DUFOURMAZOUZ.jar`: Your runnable JAR file.
- `pom.xml`: Maven configuration file.
- `README.md`

## Running the Project

1. Ensure you have Java 21 installed on your machine.
2. Open a terminal or command prompt.
3. Navigate to the project directory.
4. Run the following command to execute the JAR file:

   ```bash
   mvnw clean compile
   java -jar DufourMazou.jar
   ```
