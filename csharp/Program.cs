using System;
using System.Collections.Generic;

// Базовий клас Employee - демонстрація інкапсуляції
public abstract class Employee
{
    // Приватні поля - інкапсуляція
    private string _name;
    private decimal _salary;

    // Конструктор
    public Employee(string name, decimal salary)
    {
        _name = name;
        _salary = salary;
    }

    // Властивості для доступу до приватних полів
    public string Name
    {
        get { return _name; }
        set { _name = value; }
    }

    public decimal Salary
    {
        get { return _salary; }
        set { _salary = value; }
    }

    // Віртуальний метод - може бути перевизначений в похідних класах
    public virtual decimal CalculateSalary()
    {
        return _salary;
    }

    // Абстрактний метод - повинен бути реалізований в похідних класах
    public abstract string GetDescription();

    // Звичайний метод
    public void DisplayInfo()
    {
        decimal salary = CalculateSalary();
        Console.WriteLine($"{GetDescription()}: {Name}, Salary: {salary}");
    }
}

// Похідний клас Manager - демонстрація спадкування та поліморфізму
public class Manager : Employee
{
    // Бонус менеджера
    private decimal _bonus;

    public Manager(string name, decimal salary, decimal bonus) 
        : base(name, salary)
    {
        _bonus = bonus;
    }

    // Перевизначення віртуального методу
    public override decimal CalculateSalary()
    {
        return Salary + _bonus;
    }

    // Реалізація абстрактного методу
    public override string GetDescription()
    {
        return "Manager";
    }
}

// Конкретний клас RegularEmployee
public class RegularEmployee : Employee
{
    public RegularEmployee(string name, decimal salary) 
        : base(name, salary)
    {
    }

    // Реалізація абстрактного методу
    public override string GetDescription()
    {
        return "Employee";
    }
}

// Клас Program - демонстрація поліморфізму
public class Program
{
    static void Main()
    {
        Console.WriteLine("===== OOP Polymorphism Example (C#) =====\n");

        // Демонстрація поліморфізму - колекція базового типу
        List<Employee> employees = new List<Employee>
        {
            new RegularEmployee("Ivan", 15000),
            new Manager("Olena", 20000, 5000),
            new RegularEmployee("Petro", 12000),
            new Manager("Maria", 25000, 7000)
        };

        Console.WriteLine("--- Демонстрація поліморфізму ---\n");
        // Одноманітний виклик методів на об'єктах різних типів
        foreach (Employee emp in employees)
        {
            emp.DisplayInfo();
        }

        Console.WriteLine("\n--- Статистика ---\n");
        decimal totalSalary = 0;
        foreach (Employee emp in employees)
        {
            totalSalary += emp.CalculateSalary();
        }
        
        Console.WriteLine($"Total salary: {totalSalary}");
        Console.WriteLine($"Average salary: {totalSalary / employees.Count:F2}");
    }
}
