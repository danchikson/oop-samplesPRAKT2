<?php
/**
 * OOP Polymorphism Example - PHP Implementation
 * Демонстрація спадкування, інкапсуляції та поліморфізму
 * PHP 8+
 */

// Абстрактний базовий клас Employee
abstract class Employee
{
    // Приватні властивості - інкапсуляція (PHP 8+ typed properties)
    private string $name;
    private float $salary;

    public function __construct(string $name, float $salary)
    {
        $this->name = $name;
        $this->salary = $salary;
    }

    // Геттери та сеттери
    public function getName(): string
    {
        return $this->name;
    }

    public function setName(string $name): void
    {
        $this->name = $name;
    }

    public function getSalary(): float
    {
        return $this->salary;
    }

    public function setSalary(float $salary): void
    {
        $this->salary = $salary;
    }

    // Метод, який можна перевизначити
    public function calculateSalary(): float
    {
        return $this->salary;
    }

    // Абстрактний метод
    abstract public function getDescription(): string;

    // Звичайний метод
    public function displayInfo(): void
    {
        $salary = $this->calculateSalary();
        echo sprintf(
            "%s: %s, Salary: %.0f\n",
            $this->getDescription(),
            $this->name,
            $salary
        );
    }
}

// Клас Manager - спадкується від Employee
class Manager extends Employee
{
    private float $bonus;

    public function __construct(string $name, float $salary, float $bonus)
    {
        parent::__construct($name, $salary);
        $this->bonus = $bonus;
    }

    // Перевизначення методу
    public function calculateSalary(): float
    {
        return $this->getSalary() + $this->bonus;
    }

    // Реалізація абстрактного методу
    public function getDescription(): string
    {
        return "Manager";
    }
}

// Клас RegularEmployee
class RegularEmployee extends Employee
{
    // Реалізація абстрактного методу
    public function getDescription(): string
    {
        return "Employee";
    }
}

// Основна функція
function demonstratePolymorphism(): void
{
    echo "===== OOP Polymorphism Example (PHP) =====\n\n";

    // Демонстрація поліморфізму - масив базового типу
    $employees = [
        new RegularEmployee("Ivan", 15000),
        new Manager("Olena", 20000, 5000),
        new RegularEmployee("Petro", 12000),
        new Manager("Maria", 25000, 7000),
    ];

    echo "--- Демонстрація поліморфізму ---\n\n";
    // Одноманітний виклик методів на об'єктах різних типів
    foreach ($employees as $emp) {
        $emp->displayInfo();
    }

    echo "\n--- Статистика ---\n\n";
    $totalSalary = array_reduce(
        $employees,
        fn($sum, $emp) => $sum + $emp->calculateSalary(),
        0
    );
    $averageSalary = $totalSalary / count($employees);

    echo "Total salary: " . intval($totalSalary) . "\n";
    echo "Average salary: " . number_format($averageSalary, 2) . "\n";
}

// Запуск програми
demonstratePolymorphism();
?>
