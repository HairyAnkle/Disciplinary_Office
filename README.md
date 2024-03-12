# National University Disciplinary Office System

A simple Disciplinary Office system for tracking student information and related data.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Disciplinary Office for Student project is a Java-based system that provides functionalities for administrators to handle student data, offenses, and other disciplinary actions.

## Features

- Secure login functionality with admin credentials.
- Form for adding and managing student information, including personal details, courses, and offenses.
- Database interaction for storing and retrieving data securely.
- Graphical User Interface (GUI) for an intuitive and user-friendly experience.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- MySQL database server
- MySQL Connector/J (JDBC driver for MySQL)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/HairyAnkle/Disciplinary_Office.git

1. Open the project in your preferred Java IDE.

2. Ensure the MySQL Connector/J is added to your project's dependencies.

3. Update the database connection details in the students_form.java file.

4. Run the application.

# Usage
1. Launch the application by executing the main method in the login.java file.

2. Log in with the provided administrator credentials.

3. Add student details through the provided form.

4. Data will be stored in the connected MySQL database.

# Database Setup
1. Create a MySQL database named admin.

2. Update the database connection details in the students_form.java file.

3. Execute the SQL script database.sql to create the required tables.

# Contributing
Feel free to contribute by opening issues or submitting pull requests. Follow the guidelines in the Contributing.md file.

# License
This project is licensed under the MIT License.

Remember to customize it further based on your project's specific details and requirements.
