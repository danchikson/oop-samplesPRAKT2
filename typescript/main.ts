/**
 * OOP Polymorphism Example - TypeScript Implementation
 * Демонстрація спадкування, інкапсуляції та поліморфізму
 */

// Абстрактний базовий клас Employee
abstract class Employee {
    // Приватні поля - інкапсуляція
    private name: string;
    private salary: number;

    constructor(name: string, salary: number) {
        this.name = name;
        this.salary = salary;
    }

    // Геттери та сеттери
    getName(): string {
        return this.name;
    }

    setName(name: string): void {
        this.name = name;
    }

    getSalary(): number {
        return this.salary;
    }

    setSalary(salary: number): void {
        this.salary = salary;
    }

    // Метод, який можна перевизначити (virtual-like)
    calculateSalary(): number {
        return this.salary;
    }

    // Абстрактний метод
    abstract getDescription(): string;

    // Звичайний метод
    displayInfo(): void {
        const salary: number = this.calculateSalary();
        console.log(`${this.getDescription()}: ${this.name}, Salary: ${salary}`);
    }
}

// Клас Manager - спадкується від Employee
class Manager extends Employee {
    private bonus: number;

    constructor(name: string, salary: number, bonus: number) {
        super(name, salary);
        this.bonus = bonus;
    }

    // Перевизначення методу
    calculateSalary(): number {
        return this.getSalary() + this.bonus;
    }

    // Реалізація абстрактного методу
    getDescription(): string {
        return "Manager";
    }
}

// Клас RegularEmployee
class RegularEmployee extends Employee {
    // Реалізація абстрактного методу
    getDescription(): string {
        return "Employee";
    }
}

// Функція-демонстрація поліморфізму
function demonstratePolymorphism(): void {
    console.log("===== OOP Polymorphism Example (TypeScript) =====\n");

    // Демонстрація поліморфізму - масив базового типу
    const employees: Employee[] = [
        new RegularEmployee("Ivan", 15000),
        new Manager("Olena", 20000, 5000),
        new RegularEmployee("Petro", 12000),
        new Manager("Maria", 25000, 7000),
    ];

    console.log("--- Демонстрація поліморфізму ---\n");
    // Одноманітний виклик методів на об'єктах різних типів
    employees.forEach((emp: Employee) => {
        emp.displayInfo();
    });

    console.log("\n--- Статистика ---\n");
    const totalSalary: number = employees.reduce(
        (sum: number, emp: Employee) => sum + emp.calculateSalary(),
        0
    );
    const averageSalary: number = totalSalary / employees.length;

    console.log(`Total salary: ${totalSalary}`);
    console.log(`Average salary: ${averageSalary.toFixed(2)}`);
}

// Запуск программи
demonstratePolymorphism();
