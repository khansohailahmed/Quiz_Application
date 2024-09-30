# Quiz Application

## Project Overview

This project is a **Java-based Quiz Application** featuring a user-friendly graphical interface developed using **Swing** and **AWT**. It is integrated with a **MySQL database** to store and retrieve user credentials and quiz scores. The application allows users to register, log in, participate in quizzes, and view their scores.

The quiz consists of multiple-choice questions (MCQs) with a 30-second timer for each question. Users can also use a **50-50 lifeline** and navigate through the questions. The application tracks and saves user scores in the database.

## Key Features

### 1. **User Registration and Login**
   - Users can **register** by providing a unique User ID, password, and phone number.
   - User details are securely stored in the MySQL database.
   - After registration, users can log in using their credentials to access the quiz.

### 2. **Quiz Gameplay**
   - The quiz consists of a series of **multiple-choice questions (MCQs)**.
   - Users have **30 seconds per question** to select an answer.
   - A **50-50 lifeline** is available, which eliminates two incorrect options.
   - Users can **navigate** through questions before final submission.
   
### 3. **Database Connectivity**
   - The application is integrated with a **MySQL database** using **JDBC** for persistent storage of:
     - User registration data (User ID, password, phone number).
     - Quiz scores and related statistics.
   - **Data retrieval** is handled through SQL queries to validate user login, and store or fetch quiz data.

### 4. **User Interface**
   - The interface is built using **Java Swing** and **AWT**, providing a clean and interactive experience.
   - The interface includes components to display:
     - Questions and multiple-choice options.
     - Timer for each question.
     - Game rules and navigation controls.
     - Final score upon quiz completion.

### 5. **Score Management**
   - After completing the quiz, the user's score is calculated and displayed.
   - The score is saved in the MySQL database.
   - Users can choose to **play again** or exit the application after viewing their score.

## Technologies Used

- **Java**: Core programming language used for the application logic.
- **Swing and AWT**: Java libraries used to create the graphical user interface.
- **JDBC (Java Database Connectivity)**: Used for connecting to the MySQL database.
- **MySQL**: Database system used to store user data and quiz scores.
- **SQL**: Used to perform queries for data storage and retrieval.

## Installation and Setup Instructions

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed.
2. **MySQL Database**: Install MySQL on your local machine or a remote server.
3. **Java IDE**: Optional but recommended. You can use IntelliJ IDEA, Eclipse, or NetBeans.

### Database Setup

1. **Create a MySQL Database**:  
   Create a database for the application by running the following SQL query:
   ```sql
   CREATE DATABASE quiz_db;
   ```

2. **Create a User Table**:
   Run this query to create a table for user registration:
   ```sql
   CREATE TABLE users (
       user_id VARCHAR(50) PRIMARY KEY,
       password VARCHAR(50),
       phone_number VARCHAR(15)
   );
   ```

3. **Create a Scores Table**:
   Run this query to create a table for storing quiz scores:
   ```sql
   CREATE TABLE scores (
       user_id VARCHAR(50),
       score INT,
       FOREIGN KEY (user_id) REFERENCES users(user_id)
   );
   ```

### Application Setup

1. **Clone the Repository**:  
   Clone the GitHub repository to your local machine:
   ```bash
   git clone https://github.com/khansohailahmed/Quiz-Application.git
   ```

2. **Configure Database Connection**:
   - Update the database connection settings in the **JDBC** connection class (e.g., `DatabaseConnection.java`).
   ```java
   String url = "jdbc:mysql://localhost:3306/quiz_db";
   String username = "your_mysql_username";
   String password = "your_mysql_password";
   ```

3. **Compile and Run the Program**:
   You can compile and run the program using an IDE or from the command line:
   ```bash
   javac QuizApplication.java
   java QuizApplication
   ```

## Gameplay Instructions

1. **User Registration**:
   - Launch the application and register by providing a unique User ID, password, and phone number.
   - Your credentials will be saved in the database for future logins.

2. **Login**:
   - After registration, log in with your User ID and password to access the quiz.

3. **Start the Quiz**:
   - Once logged in, you can begin the quiz. You will be presented with multiple-choice questions, each with a 30-second timer.
   - Select an answer by clicking on the desired option.

4. **Use Lifelines**:
   - You can use the **50-50 lifeline** once during the quiz, which removes two incorrect options.

5. **Submit Answers**:
   - After completing the quiz, your score will be calculated and displayed.
   - The score will also be saved in the database.

6. **Play Again or Exit**:
   - After viewing your score, you can choose to play another quiz or exit the application.

## Project Structure

```
├── src
│   ├── QuizApplication.java       # Main class for starting the application
│   ├── DatabaseConnection.java    # Class for handling JDBC database connection
│   ├── UserRegistration.java      # Handles user registration
│   ├── QuizGameplay.java          # Handles the quiz logic and gameplay
│   ├── QuizQuestion.java          # Class representing individual quiz questions
│   └── README.md                  # This README file
```

### Classes

- **QuizApplication**: The main class that initializes the application.
- **DatabaseConnection**: Manages the connection between the application and MySQL database.
- **UserRegistration**: Handles user registration and login functionality.
- **QuizGameplay**: Manages quiz logic, including question display, timer, and lifelines.
- **QuizQuestion**: Represents individual questions in the quiz.

## Contributing

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push the changes to your fork.
5. Open a pull request with a description of your changes.

## License   

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any issues or questions, feel free to reach out via khansohailtufailahmed@gmail.com
