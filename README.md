# Order Processing System

## Project Description
The Order Processing System is a Java-based application developed using Hibernate, JPA, and PostgreSQL. It allows users to place orders with multiple items and view a customer's order history.

## Technologies Used
- Java 17
- Maven
- Hibernate ORM
- Jakarta Persistence API (JPA)
- PostgreSQL 18
- Eclipse IDE

## Features
- Create and manage customer records.
- Place orders containing multiple items.
- Map customers to orders using One-to-Many relationships.
- Map order items to orders using Many-to-One relationships.
- Save orders and items in a PostgreSQL database.
- Display customer order history.
- Manage database operations using transactions.

## Project Structure
```text
OrderProcessingSystem/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/order/
│       │       ├── Customer.java
│       │       ├── CustomerOrder.java
│       │       ├── OrderItem.java
│       │       ├── OrderService.java
│       │       ├── HibernateUtil.java
│       │       └── Main.java
│       └── resources/
│           └── META-INF/
│               └── persistence.xml
├── .gitignore
├── pom.xml
└── README.md
```

## Database Configuration
1. Install PostgreSQL.
2. Create a database named `orderdb`.
3. Open `src/main/resources/META-INF/persistence.xml`.
4. Configure the PostgreSQL username and password.
5. Ensure PostgreSQL is running.

Hibernate automatically creates or updates the required tables when the application starts.

**Note:** Never upload your actual database password to GitHub.

## How to Run
1. Open the project in Eclipse.
2. Right-click the project and select **Maven → Update Project**.
3. Ensure all dependencies are downloaded successfully.
4. Open `Main.java`.
5. Select **Run As → Java Application**.
6. Use the console menu to place orders, view order history, or exit.

## Console Menu
```text
===== ORDER PROCESSING SYSTEM =====
1. Place Order
2. View Customer Order History
3. Exit
```

## Author
Shrutika Shingane

## License
This project was created for educational purposes.
