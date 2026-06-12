# Student Management System

## Overview
The Student Management System is a console-based Java application developed using Core Java and the Collections Framework. It provides a menu-driven interface to perform CRUD (Create, Read, Update, Delete) operations on student records while ensuring data validation and exception handling.

## Features
* Add new student records
* View all students
* Search student by ID
* Update student details
* Delete student records
* Menu-driven user interface
* Duplicate Student ID validation
* Name validation
* Age validation (18–30)
* Grade validation using Enum (`A`, `B`, `C`, `D`, `F`)
* Exception handling for invalid user input

## Technologies Used
* Java
* Collections Framework (`ArrayList`)
* Object-Oriented Programming (OOP)
* Exception Handling
* Enum
* Scanner Class

## OOP Concepts Implemented
* Classes and Objects
* Constructors
* Encapsulation (Getters and Setters)
* Method Overriding (`toString()`)
* Data Validation
* Separation of Concerns using Service/Manager Class

## Project Structure

### Grade
* Enum for valid student grades
### Student
* Student attributes
* Constructor
* Getters and Setters
* Validation logic
* `toString()` method
### StudentManager
* Add Student
* View All Students
* Search Student
* Update Student
* Delete Student
### StudentManagementSystem
* Main Method
* Menu-Driven Interface
* User Interaction

## Validations Implemented
* Student ID must be unique
* Name cannot be null or empty
* Age must be between 18 and 30
* Grade must be one of:
  * A
  * B
  * C
  * D
  * F

## Exception Handling
* Handles invalid numeric inputs using `InputMismatchException`
* Handles invalid grade entries using `IllegalArgumentException`
* Prevents application crashes due to unexpected user input

## Menu Options
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student Details
5. Delete Student Details
6. Exit

## How to Compile and Run
### Compile
javac *.java (to compile both files StudentManagementSystem.java and Grade.java)

### Run
java StudentManagementSystem.java


## Sample Output
----- Student Management System -----

1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student Details
5. Delete Student Details
6. Exit
Enter Choice:

## Learning Outcomes

* CRUD Operations using ArrayList
* Object-Oriented Programming in Java
* Exception Handling
* Data Validation Techniques
* Enum Usage
* Menu-Driven Application Development

## Future Enhancements

* JDBC and MySQL Integration
* Spring Boot REST API
* Java Swing / JavaFX GUI
* Search by Name and Grade
* Sorting and Filtering Students

## Author
**Poorva Bhalerao**

