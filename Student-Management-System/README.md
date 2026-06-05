# Student Management System 

## Overview :
Student Management System is a Java Console-Based CRUD Application developed using Core Java and ArrayList Collection Framework. The application allows users to manage student records through a menu-driven interface. It supports adding, viewing, searching, updating, and deleting student information while performing input validation and exception handling.

## Features:
### Create Student 
* Add new student records. 
* Accepts:  Student ID , Name , Age , Grade , Email 
### Read Student 
*Data 
* View all student records. 
* Search student by ID. 
### Update Student Data 
* Update existing student information. 
* Modify: Name ,Age ,Grade ,Email
### Delete Student Data 
* Delete student record using Student ID.

## Validations Implemented 
### Name Validation 
* Name cannot be null. 
* Name cannot be empty. 
### Age Validation 
* Age must be between 18 and 30. 
### Duplicate ID Validation 
* Prevents insertion of duplicate Student IDs.

## Exception Handling 
### InputMismatchException 
* Handles invalid numeric input for: 
* Student ID 
* Age 
### IllegalArgumentException 
* Handles validation failures. 
### Generic Exception Handling 
* Prevents application crash due to unexpected user input.

## Technologies Used :Java , ArrayList , Object Oriented Programming (OOP) , Exception Handling , Scanner Class ,Collections Framework 

## OOP Concepts Used :
### Class and Object :  
### Constructor : Parameterized constructor used to initialize student details. 
### Encapsulation : Getters and Setters used to access and modify data.
### Method Overriding : toString() overridden for displaying student information.

## Project Structure :
Student : Data Members , Constructor ,Getters , Setters 
StudentManager:  Validation Logic , CRUD Operations 
StudentManagementSystem : Main Method , Menu Driven Interface , User Interaction

## Learning Outcomes Through this project I learned: CRUD Operations in Java , ArrayList Manipulation , Object Oriented Programming Concepts , Constructor Validation , Exception Handling , Menu Driven Applications , Search and Update Operations , Data Validation Techniques 

## Future Enhancements: Database Integration using JDBC , Spring Boot REST API Version * MySQL Integration
