🚗 Car Rental System
An Object-Oriented Java application built to manage vehicle rentals and customer bookings efficiently. The system features a dynamic pricing engine, complete reservation workflows, and multiple car categories.
🌟 Key Features
Reservation Workflows: Create, search, and cancel bookings using Customer ID and Car Plate Number.
Fleet Management: Supports Economy, SUV, and Luxury SUV categories.
Dynamic Pricing Engine: Calculates rental costs automatically based on duration, vehicle class, fuel type (Petrol/Diesel), and VIP add-ons.
OOP Architecture: Designed using Core Java concepts such as Inheritance, Polymorphism, Interfaces, and Composition.
💻 Tech Stack
Language: Java
Environment: NetBeans IDE
Core Concepts: Object-Oriented Programming (OOP), Recursive Algorithms, Data Modeling
📋 Available Operations
Add New Reservation
Cancel Existing Reservation
Search Reservation by ID & Plate
Print Economy Cars (Recursive Display)
Print All Active Reservations
View Available Fleet Status

🎬 Program Execution (Sample Run)
Below is an interactive walkthrough showing how the Car Rental System processes commands in the terminal:
1. View Available Fleet (Option 6)
------KSU Car Rental------
1- Add Reservation
2- cancel reservation
3- Search reservation
4- Print economy Cars
5- Print All Reservations
6- view available cars
0- Exit
Enter choice: 6

Economy Car:  plateNo= DCA-121 available= true pricePerDay= 120.0 fuelType: Diesel services: 1 final Price= 130.0
Economy Car:  plateNo= MBA-333 available= true pricePerDay= 70.0 fuelType: Diesel services: 1 final Price= 80.0
SUV Car :  plateNo= SUV-222 available= true pricePerDay= 200.0 has a fullPackage : true
SUV Car :  plateNo= SUV-111 available= true pricePerDay= 120.0 has a fullPackage : true
SUV Car :  plateNo= SUV-444 available= true pricePerDay= 90.0 has a fullPackage : false
Luxury SUV Car: plateNO= LUX-333 price per day 400.0 full package true VIP Package: true Services: 4 Final Price: 580.0
Luxury SUV Car: plateNO= LUX-686 price per day 300.0 full package false VIP Package: true Services: 4 Final Price: 460.0
Luxury SUV Car: plateNO= LUX-999 price per day 500.0 full package true VIP Package: false Services: 2 Final Price: 570.0

Enter choice: 1 Enter Car Plate number : ABC-111 Enter Name: Ahmed Ali Enter Mobile: 057777 Enter ID: 1111 Enter number of days you want to make reservation for : 3 Reservation added successfully!
Reservation:  fullName: Ahmed Ali mobile= 057777 ID= 1111 Plate Number= ABC-111 Number of Days= 3 Total Price= 570.0

Enter choice: 4
Economy Cars:
Economy Car:  plateNo= ABC-111 available= false pricePerDay= 150.0 fuelType: Petrol services: 2 final Price= 190.0
Economy Car:  plateNo= DCA-121 available= true pricePerDay= 120.0 fuelType: Diesel services: 1 final Price= 130.0
Economy Car:  plateNo= MBA-333 available= true pricePerDay= 70.0 fuelType: Diesel services: 1 final Price= 80.0

Enter choice: 2
Enter the id for the reservation 1234
Enter the plate for the car: ABC-111
Cancelation is done

