# ☕ Descaling Program for Fully Automatic Coffee Machine

This project simulates the descaling and operation cycle of a fully automatic coffee machine. The application monitors descaling fluid levels, restricts coffee-making after repeated use, and guides users through a three-phase descaling process.

---

## 📑 Project Overview

This system was developed as part of a Software Engineering course project. It simulates hardware interaction and user-driven actions through a modular, object-oriented architecture.

---

## 🛠 Features

- ✅ Prepare up to 5 cups of coffee before descaling is required
- ✅ Simulated fluid sensor and tank management
- ✅ Three-phase descaling program (filling, soaking, rinsing)
- ✅ Log system that records key events with timestamps
- ✅ Display system for user feedback
- ✅ CLI-based interface

---

## 🧩 System Architecture

- `MainController`: Manages system flow and coordinates user actions
- `CoffeeMachine`: Core logic for coffee preparation and descaling control
- `DescalingTank`: Manages fluid levels
- `FluidSensor`: Simulates fluid reading hardware
- `DescalingPhaseManager`: Handles 3-step descaling process
- `LogManager`: Records all events (coffee, descaling, refills)
- `Display`: Displays system status and user messages

> For full architecture and design diagrams, see the `descaling program project final.docx` file in the repo.

---

## 🚀 How to Run

### Prerequisites:
- Java 17+
- IntelliJ IDEA (or any Java IDE)

### Steps:
1. Clone this repo:
   ```bash
   git clone https://github.com/AmeenCodeBox/CoffeeMachineDescalingProject.git
   ```
2. Open the project in your IDE.
3. Run `Main.java` to start the console version.
---

## 🧪 Testing

Manual test cases have been implemented and executed. All results are documented in the `descaling program project.docx` under section 6.

---

## 📄 Documentation

The full project documentation is provided in:
- `descaling program project final.docx` – full report (requirements, architecture, test plan)
- `Erklärung.pdf` – signed declaration

---

## 👨‍💻 Author

- **Ameen Mahagna**  
  Bachelor’s student in Artificial Intelligence  
  Technische Hochschule Deggendorf (THD)  
  [GitHub Profile](https://github.com/AmeenCodeBox)

---

## 📝 License

This project is part of a university course and is not intended for commercial use. See `LICENSE` if applicable.
