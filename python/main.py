#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
OOP Polymorphism Example - Python Implementation
Демонстрація спадкування, інкапсуляції та поліморфізму
"""

from abc import ABC, abstractmethod
from typing import List


class Employee(ABC):
    """
    Базовий абстрактний клас Employee
    Демонструє інкапсуляцію через приватні атрибути
    """

    def __init__(self, name: str, salary: float):
        """Конструктор з ініціалізацією приватних полів"""
        self._name = name  # Приватне поле
        self._salary = salary  # Приватне поле

    @property
    def name(self) -> str:
        """Геттер для імені"""
        return self._name

    @name.setter
    def name(self, value: str) -> None:
        """Сеттер для імені"""
        self._name = value

    @property
    def salary(self) -> float:
        """Геттер для зарплати"""
        return self._salary

    @salary.setter
    def salary(self, value: float) -> None:
        """Сеттер для зарплати"""
        self._salary = value

    def calculate_salary(self) -> float:
        """
        Метод для розрахунку зарплати
        Може бути перевизначений в похідних класах
        """
        return self._salary

    @abstractmethod
    def get_description(self) -> str:
        """Абстрактний метод - повинен бути реалізований"""
        pass

    def display_info(self) -> None:
        """Виведення інформації про працівника"""
        salary = self.calculate_salary()
        print(f"{self.get_description()}: {self.name}, Salary: {salary}")


class Manager(Employee):
    """
    Клас Manager - спадкується від Employee
    Демонструє поліморфізм через перевизначення методів
    """

    def __init__(self, name: str, salary: float, bonus: float):
        """Конструктор з бонусом"""
        super().__init__(name, salary)
        self._bonus = bonus  # Додаткове поле для менеджера

    def calculate_salary(self) -> float:
        """Перевизначення методу - менеджер отримує бонус"""
        return self._salary + self._bonus

    def get_description(self) -> str:
        """Реалізація абстрактного методу"""
        return "Manager"


class RegularEmployee(Employee):
    """Клас для звичайного працівника"""

    def calculate_salary(self) -> float:
        """Регулярний працівник отримує звичайну зарплату"""
        return self._salary

    def get_description(self) -> str:
        """Реалізація абстрактного методу"""
        return "Employee"


def main():
    """Основна функція - демонстрація поліморфізму"""
    print("===== OOP Polymorphism Example (Python) =====\n")

    # Демонстрація поліморфізму - список базового типу
    employees: List[Employee] = [
        RegularEmployee("Ivan", 15000),
        Manager("Olena", 20000, 5000),
        RegularEmployee("Petro", 12000),
        Manager("Maria", 25000, 7000),
    ]

    print("--- Демонстрація поліморфізму ---\n")
    # Одноманітний виклик методів на об'єктах різних типів
    for emp in employees:
        emp.display_info()

    print("\n--- Статистика ---\n")
    total_salary = sum(emp.calculate_salary() for emp in employees)
    average_salary = total_salary / len(employees)

    print(f"Total salary: {total_salary}")
    print(f"Average salary: {average_salary:.2f}")


if __name__ == "__main__":
    main()
