# Practical Assignment №2: OOP Polymorphism Examples

## 📝 Description

This project demonstrates Object-Oriented Programming (OOP) principles through implementing the same domain logic (Employee and Manager classes) in **four different programming languages**: C#, Python, TypeScript, and PHP.

Each implementation showcases:
- **Inheritance** - Manager inherits from Employee
- **Encapsulation** - Private fields with public properties/getters/setters
- **Polymorphism** - Runtime method overriding and virtual methods
- **Abstraction** - Abstract classes and methods

---

## 🏗️ Architecture

### Domain Model

#### Base Class: `Employee`
- **Fields:**
  - `name: string` (private)
  - `salary: float/decimal` (private)
- **Methods:**
  - `calculateSalary()` - returns base salary
  - `getDescription()` - abstract method
  - `displayInfo()` - prints employee information

#### Derived Class: `Manager`
- **Inherits:** Employee
- **Additional Field:**
  - `bonus: float/decimal` (private)
- **Overridden Methods:**
  - `calculateSalary()` - returns salary + bonus
  - `getDescription()` - returns "Manager"

#### Concrete Class: `RegularEmployee`
- **Inherits:** Employee
- **Overridden Methods:**
  - `getDescription()` - returns "Employee"

---

## 🔄 Polymorphism Demonstration

Each implementation creates:
1. A **collection** of base type Employee
2. **Multiple objects** (both RegularEmployee and Manager)
3. **Uniform method calls** on different types
4. **Runtime polymorphism** in action

### Expected Output (All Languages)
```
===== OOP Polymorphism Example (Language) =====

--- Демонстрація поліморфізму ---

Employee: Ivan, Salary: 15000
Manager: Olena, Salary: 25000
Employee: Petro, Salary: 12000
Manager: Maria, Salary: 32000

--- Статистика ---

Total salary: 84000
Average salary: 21000.00
```

---

## 📂 Project Structure

```
oop-samplesPRAKT2/
├── csharp/
│   └── Program.cs           # C# implementation
├── python/
│   └── main.py              # Python implementation
├── typescript/
│   └── main.ts              # TypeScript implementation
├── php/
│   └── main.php             # PHP implementation
├── retail-project/          # Original Java retail system
└── README.md                # This file
```

---

## 🚀 How to Run

### C# Implementation
```bash
cd csharp
dotnet new console -n PolymorphismExample
# Copy Program.cs to the project
dotnet run
```

Or compile and run directly:
```bash
cd csharp
csc Program.cs
./Program.exe  # Windows
./Program     # Linux/Mac
```

### Python Implementation
```bash
cd python
python3 main.py
```

### TypeScript Implementation
```bash
cd typescript
npx ts-node main.ts
```

Or compile to JavaScript:
```bash
cd typescript
tsc main.ts
node main.js
```

### PHP Implementation
```bash
cd php
php main.php
```

**Requirements:** PHP 8.0+

---

## 🎓 Key Concepts Explained

### 1. Inheritance
```
Employee (base class)
├── Manager (derived class)
└── RegularEmployee (derived class)
```

### 2. Encapsulation
- Private fields: `_name`, `_salary`
- Public accessors: getters and setters
- Controlled access to internal state

### 3. Polymorphism
```cpp
List<Employee> employees = [Manager, RegularEmployee, Manager, ...];
foreach(emp in employees) {
    emp.displayInfo();  // Correct method called based on actual type
}
```

### 4. Abstraction
- Abstract class `Employee`
- Abstract method `getDescription()`
- Derived classes provide implementations

### 5. Virtual Methods
- `calculateSalary()` - base implementation
- Can be overridden in derived classes
- Runtime dispatch determines which version is called

---

## 📊 Comparison Table

| Feature | C# | Python | TypeScript | PHP |
|---------|----|---------|-----------| ----|
| Abstract Classes | ✅ abstract | ✅ ABC | ✅ abstract | ✅ abstract |
| Access Modifiers | private/public | _private convention | private/public | private/public |
| Inheritance | `: Employee` | `(Employee)` | `extends Employee` | `extends Employee` |
| Virtual Methods | override | def override | override | override |
| Type Hints | ✅ Strong | ✅ Type hints | ✅ Strong | ✅ PHP 8+ types |
| Collections | `List<T>` | `list` | `T[]` | `array` |

---

## ✅ Code Quality

All implementations follow:
- **Clean Code** principles
- **Language-specific best practices**
- **No external dependencies**
- **Full encapsulation**
- **Proper documentation**
- **Identical logic across all languages**

---

## 🎯 Learning Outcomes

By studying these implementations, you will understand:

1. ✅ How inheritance works in different languages
2. ✅ Differences between abstract classes and interfaces
3. ✅ How polymorphism enables flexible code
4. ✅ Encapsulation and access control patterns
5. ✅ Language-specific syntax variations
6. ✅ Runtime method dispatch mechanisms

---

## 📋 Assignment Completion Checklist

- ✅ Employee base class with private fields
- ✅ Manager derived class with bonus
- ✅ Abstract methods
- ✅ Polymorphism demonstration
- ✅ Collection-based iteration
- ✅ Identical output format
- ✅ Four language implementations
- ✅ No external dependencies
- ✅ Fully documented code
- ✅ Runnable in all languages

---

## 🏆 University Report Conclusion

### Summary
This practical assignment successfully demonstrates that **Object-Oriented Programming principles are language-agnostic**. The same domain model (Employee and Manager) implemented in C#, Python, TypeScript, and PHP shows:

1. **Universality of OOP concepts** - Inheritance, encapsulation, and polymorphism work consistently across languages
2. **Implementation differences** - While principles remain the same, syntax and idioms vary
3. **Importance of design** - A well-designed class hierarchy is the foundation of maintainable code
4. **Practical polymorphism** - Runtime method dispatch enables flexible, extensible architectures

### Technical Achievements
- All four implementations compile/run without errors
- Identical business logic across languages
- Proper use of language features
- Clean, readable, maintainable code
- Professional documentation

### Educational Value
Students gaining proficiency in multiple languages understand:
- Core OOP principles transcend syntax
- Design patterns remain consistent
- Language choice depends on use case, not concepts
- Professional developers must be language-flexible

---

## 👨‍💻 Author

Practical Assignment №2
**Date:** December 16, 2025
**Status:** ✅ Complete
**Languages:** C#, Python, TypeScript, PHP

---

## 📚 References

- OOP Principles: https://en.wikipedia.org/wiki/Object-oriented_programming
- Polymorphism: https://en.wikipedia.org/wiki/Polymorphism_(computer_science)
- Inheritance: https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming)
- Encapsulation: https://en.wikipedia.org/wiki/Encapsulation_(computer_programming)

---

**Happy Learning! 🚀**