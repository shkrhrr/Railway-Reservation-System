# 🚆 Railway Reservation System

A console-based railway reservation system built using Java.

I made this project to bring different Java concepts together in one application instead of using them only in separate programs. The system covers train searching, seat management, ticket booking, cancellation, PNR generation, and saving booking records.

## ✨ Features

* 🔎 Search for trains
* 🚆 View available trains
* 💺 Check seat availability
* 🎫 Book a ticket
* 🔢 Generate a PNR for each ticket
* ❌ Cancel a ticket
* 🔍 Search for a booking using its PNR
* 📋 View current bookings
* 💾 Save booking details to a file
* 📖 Read previously saved booking details
* ⚠️ Handle unavailable seats with a custom exception

## 🛠️ Built With

* ☕ Java
* 💻 Visual Studio Code
* 🌐 Git and GitHub

## 📚 Java Concepts Used

The project uses several concepts from Java, including:

* Classes and Objects
* Constructors
* Inheritance
* Abstract Classes
* Interfaces
* Encapsulation
* Polymorphism
* Method Overriding
* Exception Handling
* Custom Exceptions
* ArrayList
* Stack
* 2-D Arrays
* File Handling
* BufferedReader
* BufferedWriter
* Synchronization

## 📁 Project Structure

```text
Railway-Reservation-System/
│
├── Main.java
├── User.java
├── Passenger.java
├── Train.java
├── Ticket.java
├── ReservationService.java
├── Bookable.java
├── SeatNotAvailableException.java
├── FileManager.java
├── .gitignore
└── README.md
```

## 🧩 Classes

### Main.java

Contains the `main()` method and the menu through which the user can access the different features of the program.

### User.java

An abstract class that contains the common details and methods for users.

### Passenger.java

Extends the `User` class and stores passenger details such as name, phone number, age, and gender.

### Train.java

Stores the train number, train name, source, destination, fare, and seat information. It also contains the methods used for booking and cancelling seats.

### Ticket.java

Stores the details of a booked ticket and generates a PNR number for it.

### ReservationService.java

Handles the main reservation operations. It keeps track of trains and tickets and provides methods for searching, booking, cancelling, and viewing bookings.

### Bookable.java

An interface containing the methods related to ticket booking and cancellation.

### SeatNotAvailableException.java

A custom exception used when a user tries to book a seat that is not available.

### FileManager.java

Handles saving booking information to a file and reading the saved records later.

## 💺 Seat Management

Seats are represented using a 2-D boolean array:

```java
boolean[][] seats = new boolean[5][10];
```

This gives the system 5 rows with 10 seats in each row.

```text
false = Available
true  = Booked
```

The seat status is updated when a ticket is booked or cancelled.

## 🚆 Sample Trains

The program includes a few sample trains for testing:

| Train             | Route               |  Fare |
| ----------------- | ------------------- | ----: |
| Rajdhani Express  | Bhopal to New Delhi |  ₹850 |
| Bhopal Express    | Bhopal to Mumbai    |  ₹650 |
| Karnataka Express | Bhopal to Bangalore | ₹1100 |

## 💾 File Handling

The project uses file handling to save booking information locally.

The main classes used are:

```java
FileReader
FileWriter
BufferedReader
BufferedWriter
```

Booking information can be written to a file and read again when required.

The `.gitignore` file is used to keep compiled `.class` files out of the GitHub repository.

## ⚠️ Exception Handling

The project has a custom exception called `SeatNotAvailableException`.

It is used when a user tries to book a seat that has already been booked or is not available.

This allows the program to handle the situation without stopping the entire application.

## 🔒 Synchronization

The booking method in `Train.java` is declared as `synchronized`.

This was used to demonstrate synchronization in Java and to make the seat booking operation safer when accessed by multiple threads.

## ▶️ How to Run

### 1. Check Java Installation

Make sure the Java Development Kit is installed on your computer.

```bash
java --version
javac --version
```

### 2. Open the Project

Open the project folder in Visual Studio Code and open a terminal in that folder.

### 3. Compile the Program

```bash
javac *.java
```

### 4. Run the Program

```bash
java Main
```

The reservation menu will appear in the terminal.

## 🔄 Basic Program Flow

```text
Start
  |
  v
Main Menu
  |
  +-- View Trains
  |
  +-- Search Train
  |
  +-- Check Seat Availability
  |
  +-- Book Ticket
  |      |
  |      +-- Enter Passenger Details
  |      +-- Select Seat
  |      +-- Generate PNR
  |
  +-- Cancel Ticket
  |
  +-- Search Booking by PNR
  |
  +-- View Bookings
  |
  +-- Read Saved Bookings
  |
  +-- Exit
```

## 🚀 Possible Improvements

There are several features that could be added to the project in the future:

* 👤 User login and registration
* 🔐 Separate admin section
* 👥 Booking for multiple passengers
* ⏳ Waiting list management
* 🚆 Different train classes such as Sleeper and AC
* 🗄️ Database connectivity
* 🖥️ Graphical user interface
* 💳 Payment simulation
* 🕐 Train schedules and platform information

## 🎯 Project Objective

The purpose of this project was to build a small railway reservation application while practicing the Java concepts covered in the course.

Working on the project helped me understand how concepts such as inheritance, interfaces, collections, exception handling, file handling, arrays, and synchronization can work together in one application.

## 👨‍💻 Author

**Shikhar**

⭐ Java Academic Project
