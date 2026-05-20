# Car Dealership Application

## Description of the Project

DealershipApp is a Java console application designed for sales managers at a car dealership. It allows managers to search, add, and remove vehicles from the dealership's inventory which is stored and saved in a CSV file.
The application allows users to search vehicles by price range, make and model, year range, color, mileage range, and vehicle type. Managers can also add new vehicles to the inventory or remove sold vehicles.
In addition to inventory management, the app supports recording vehicle sales and leases. When a vehicle is sold, the app collects customer information, calculates sales tax, recording fees, processing fees, and optionally calculates monthly payments based on financing terms. When a vehicle is leased, the app validates that the vehicle is not older than 3 years, calculates the expected ending value and lease fee, and computes monthly lease payments. All contracts are saved to a separate CSV file for record keeping.
The app is built using a layered architecture with separate classes for vehicle data, dealership management, file reading and writing, contract types, and the user interface.
## User Stories
- As a sales manager, I want to see a menu, so that I can choose what to do in the app.
- As a sales manager, I want the app to load the dealership inventory on startup, so that I can see the current vehicles.
- As a sales manager, I want to list all vehicles, so that I can see the full inventory.
- As a sales manager, I want to search vehicles by price range, so that I can find vehicles within a budget.
- As a sales manager, I want to search vehicles by make and model, so that I can find specific brands.
- As a sales manager, I want to search vehicles by year range, so that I can find vehicles from a specific era.
- As a sales manager, I want to search vehicles by color, so that I can find vehicles of a specific color.
- As a sales manager, I want to search vehicles by mileage range, so that I can find vehicles with low or high mileage.
- As a sales manager, I want to search vehicles by type, so that I can find cars, trucks, SUVs, or vans.
- As a sales manager, I want to add a vehicle to the inventory, so that I can keep the dealership up to date.
- As a sales manager, I want to remove a vehicle from the inventory, so that I can keep the dealership up to date.
- As a sales manager, I want to record a vehicle sale, so that I can track purchases and generate contracts.
- As a sales manager, I want to record a vehicle lease, so that I can track leases and generate contracts.
- As a sales manager, I want contracts saved to a file, so that I have a permanent record of all sales and leases.
- As a developer, I want a Vehicle class, so that I can store vehicle information.
- As a developer, I want a Dealership class, so that I can store dealership information and manage inventory.
- As a developer, I want an abstract Contract class, so that I can share common fields between sales and lease contracts.
- As a developer, I want a SalesContract class, so that I can calculate pricing for vehicle purchases.
- As a developer, I want a LeaseContract class, so that I can calculate pricing for vehicle leases.



## Setup

Instructions on how to set up and run the project using IntelliJ IDEA.

### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK is installed and configured in IntelliJ.

### Running the Application in IntelliJ

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the Program class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'YourMainClassName.main()'' to start the application.

## Technologies Used

- Java 17

## Demo



## Future Work


## Resources

- [Java Visual Learning Hub](https://raymaroun.github.io/yearup-java-visuals/)
- [Java W3 Schools](https://www.w3schools.com/java/default.asp)
- [GeekforGeeks](https://www.geeksforgeeks.org/java/java/)


## Thanks


- Thank you to Raymond for continuous support and guidance.
- Thank you to my peers for support
