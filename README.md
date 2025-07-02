# 📚 Library Management System

A **console-based Library Management System in Java** demonstrating core **Object-Oriented Programming**, **SOLID principles**, and use of **design patterns** like Factory and Observer. It supports book lending, patron tracking, reservations, multi-branch support (optional), and book recommendations.

---

## 🛠️ Features

### ✅ Core Functionalities
- **Book Management**
  - Add, remove, and update books
  - Search books by title, author, or ISBN
- **Patron Management**
  - Add/update patrons
  - Track borrowing & reservation history
- **Lending**
  - Checkout and return books
  - Track book availability
- **Inventory Tracking**
  - List available and borrowed books

### 💡 Optional Extensions
- **Multi-Branch Support** *(extensible with current structure)*
- **Reservation System**
  - Patrons can reserve books and get notified when available
- **Notification System**
  - Uses Observer pattern to notify patrons
- **Recommendation Engine**
  - Suggests books based on borrowing patterns

---

## 💻 Technologies Used

| Tech / Concept     | Usage                                                                 |
|--------------------|------------------------------------------------------------------------|
| Java               | Core language                                                         |
| OOP Principles     | Encapsulation, Inheritance, Abstraction, Polymorphism                 |
| SOLID Principles   | Modular & maintainable class design                                   |
| Design Patterns    | Factory (book creation), Observer (notifications)                     |
| Java Collections   | `List`, `Map`, `Set` for storing books, patrons, and history          |
| Logging            | Java `java.util.logging` to log events in `library.log`               |

---

## 🧱 Project Structure

```
Library-Management-System/
├── README.md
├── library.log
├── class-diagram.png           ← UML diagram (exported)
└── src/
    ├── Main.java
    ├── config/
    │   └── LoggerConfig.java
    ├── book/
    │   ├── Book.java
    │   ├── BookInventory.java
    │   └── BookFactory.java         ← Factory Pattern
    ├── patron/
    │   ├── Patron.java
    │   └── PatronHistory.java
    ├── lending/
    │   ├── LendingService.java
    │   └── ReservationService.java
    ├── notification/
    │   ├── NotificationService.java
    │   └── Observer.java            ← Observer Pattern
    └── recommendation/
        └── RecommendationService.java
```

---

## ▶️ How to Run the Program

### 1. Clone or Download the Repository
```bash
git clone https://github.com/your-username/Library-Management-System.git
cd Library-Management-System/src
```

### 2. Compile All Java Files
```bash
javac */*.java */*/*.java Main.java
```

### 3. Run the Program
```bash
java Main
```

### 4. Check Logs
```bash
cd ..
cat library.log
```

---

## 📄 Sample Output

```
Available books:
1984 by George Orwell - Available: false
Animal Farm by George Orwell - Available: true

Borrowing history:
Book: 1984 | Borrowed on: 2025-07-02

Reservation history:
124

Recommended books:
Animal Farm by George Orwell
```

---

## 🧪 Test Scenarios

- ✅ Valid & invalid book checkout
- ✅ Reservation followed by return and notification
- ✅ Recommendation generation
- ✅ Logging for checkout, return, errors, and notifications

---

## 🖼️ Class Diagram

Please refer to `class-diagram.png` in the root directory.

---

## 🧑‍💻 Contributors

- **Amit Mondal** – Full implementation, design, and documentation

---

## 🔗 License

MIT License — feel free to use, modify, and share with credit.