# 📚 Документація проєкту "Система Ритейл"

## Структура документації

### 📖 Основні документи
1. **[README.md](README.md)** - Загальний опис проєкту, архітектура, команди компіляції та запуску
2. **[QUICKSTART.md](QUICKSTART.md)** - Швидкий старт для нових розробників
3. **[ANALYSIS.md](ANALYSIS.md)** - Детальний аналіз Java-коду та компонентів системи
4. **[COMPARISON.md](COMPARISON.md)** - Порівняння PlantUML та Mermaid діаграм, відповідність коду документації

---

## 📊 Діаграми

### PlantUML (у папці `/docs`)
- **[docs/class.puml](docs/class.puml)** - UML-діаграма класів
- **[docs/usecase.puml](docs/usecase.puml)** - UML-діаграма варіантів використання
- **[docs/sequence.puml](docs/sequence.puml)** - UML-діаграма послідовності
- **[docs/state.puml](docs/state.puml)** - UML-діаграма станів
- **[docs/requirements.md](docs/requirements.md)** - Вимоги до системи

### Mermaid (у папці `/diagrams`)
Mermaid версії діаграм, інтегровані з GitHub та легко редагуються у Markdown:

#### Use Case Diagram
```
📝 Діаграма варіантів використання
├── 3 актори: Менеджер, Постачальник, Логіст
├── 6 use case'ів
└── Залежності між use case'ами
```
👉 **[diagrams/usecase-mermaid.md](diagrams/usecase-mermaid.md)**

#### Class Diagram
```
📐 Діаграма класів
├── 1 інтерфейс (ISupplyPlan)
├── 1 абстрактний клас (ParticipantSupply)
├── 3 конкретні класи (Manager, Supplier, Logistician)
├── 2 сутності (SupplyOrder, OrderPosition)
└── 1 служба (DeliveryService)
```
👉 **[diagrams/class-mermaid.md](diagrams/class-mermaid.md)**

#### Sequence Diagrams
```
🔄 Діаграми послідовності

Сценарій 1: Успішне замовлення
├── Створення замовлення
├── Додавання позицій
├── Підтвердження та накладна
├── Планування та доставка
└── Статус: Delivered
```
👉 **[diagrams/sequence-scenario1-mermaid.md](diagrams/sequence-scenario1-mermaid.md)**

```
Сценарій 2: Замовлення з поверненням
├── Весь процес Сценарію 1
├── Виявлення проблеми
└── Оформлення повернення
```
👉 **[diagrams/sequence-scenario2-mermaid.md](diagrams/sequence-scenario2-mermaid.md)**

#### State Diagram
```
🔀 Діаграма станів
├── [START]
├── Created
├── Confirmed
├── Invoiced
├── Shipping
├── Delivered (розгалуження)
│   ├── SUCCESS → [END]
│   └── PROBLEM → Returned → [END]
└── [END]
```
👉 **[diagrams/state-mermaid.md](diagrams/state-mermaid.md)**

---

## 💻 Джерельний код

### Java класи (у папці `/src`)
```
src/
├── Application.java           - Головний клас з методом main
├── ParticipantSupply.java    - Абстрактний клас учасника
├── Manager.java              - Менеджер магазину
├── Supplier.java             - Постачальник
├── Logistician.java          - Логіст
├── SupplyOrder.java          - Замовлення
├── OrderPosition.java        - Позиція замовлення
├── DeliveryService.java      - Служба доставки
└── ISupplyPlan.java          - Інтерфейс плану
```

---

## 🚀 Як використовувати документацію

### Для нових розробників
1. Прочитайте **[README.md](README.md)** для розуміння проєкту
2. Подивіться **[QUICKSTART.md](QUICKSTART.md)** для запуску коду
3. Переглядайте **[diagrams/](diagrams/)** для розуміння архітектури

### Для аналітиків та архітекторів
1. Почніть з **[ANALYSIS.md](ANALYSIS.md)** для глибокого розуміння
2. Порівняйте PlantUML та Mermaid у **[COMPARISON.md](COMPARISON.md)**
3. Вивчайте діаграми у обох форматах

### Для представників бізнесу
1. Подивіться на Use Case діаграму для розуміння функціоналу
2. Диаграма станів показує процес замовлення
3. Вимоги в **[docs/requirements.md](docs/requirements.md)**

---

## 📋 Таблиця компонентів

| Компонент | Файл | Тип | Опис |
|-----------|------|-----|------|
| Manager | src/Manager.java | Клас | Менеджер магазину |
| Supplier | src/Supplier.java | Клас | Постачальник |
| Logistician | src/Logistician.java | Клас | Логіст |
| SupplyOrder | src/SupplyOrder.java | Клас | Замовлення |
| OrderPosition | src/OrderPosition.java | Клас | Позиція замовлення |
| DeliveryService | src/DeliveryService.java | Клас | Служба доставки |
| ParticipantSupply | src/ParticipantSupply.java | Абстрактний клас | База для учасників |
| ISupplyPlan | src/ISupplyPlan.java | Інтерфейс | Контракт для планування |
| Application | src/Application.java | Клас | Точка входу |

---

## 🔍 Ключові концепції

### Об'єктно-орієнтоване програмування
- ✓ **Спадкування**: Manager, Supplier, Logistician → ParticipantSupply
- ✓ **Поліморфізм**: Різні реалізації методів у підклаcах
- ✓ **Інкапсуляція**: Приватні атрибути, публічні методи
- ✓ **Абстракція**: Інтерфейс ISupplyPlan та абстрактний клас ParticipantSupply

### Design Patterns
- 🎯 **Strategy Pattern**: DeliveryService для стратегії доставки
- 🎯 **Template Method**: Послідовність операцій у сценаріях
- 🎯 **Observer Pattern**: Система спостереження за статусом замовлення

### Архітектурні рішення
- 📐 **Компонента архітектура**: Чіткий поділ на сутності та учасники
- 📐 **Залежності**: Логіст залежить від DeliveryService
- 📐 **Стани**: Explicit State Pattern для управління статусом замовлення

---

## 📊 Метрики проєкту

| Метрика | Значення |
|---------|----------|
| **Класів** | 9 |
| **Інтерфейсів** | 1 |
| **Абстрактних класів** | 1 |
| **Методів** | ~20 |
| **Атрибутів** | ~10 |
| **Use Cases** | 6 |
| **Сценаріїв** | 2 |
| **Станів замовлення** | 7 |
| **Lines of Code (src/)** | ~300 |
| **Документації** | 5 файлів |
| **Діаграм** | 8 (4 PlantUML + 5 Mermaid) |

---

## 🔗 Навігаційні посилання

### За типом користувача

**👨‍💻 Розробник**
- [QUICKSTART.md](QUICKSTART.md) → Як запустити
- [src/](src/) → Код
- [diagrams/](diagrams/) → Архітектура

**🏗️ Архітектор**
- [ANALYSIS.md](ANALYSIS.md) → Аналіз
- [COMPARISON.md](COMPARISON.md) → Порівняння
- [docs/](docs/) та [diagrams/](diagrams/) → Діаграми

**📚 Студент**
- [README.md](README.md) → Огляд
- [ANALYSIS.md](ANALYSIS.md) → Глибокий аналіз
- [src/](src/) → Код для вивчення

---

## ✅ Контрольний список якості документації

- ✓ Повна архітектурна документація
- ✓ Діаграми у двох форматах (PlantUML + Mermaid)
- ✓ Аналіз коду та документації
- ✓ Порівняння з рекомендаціями
- ✓ Швидкий старт для розробників
- ✓ Вимоги та сценарії використання
- ✓ Примітки про концепції OOP
- ✓ Індекс та навігація

---

**Останнього оновлення:** 6 грудня 2025

**Версія проєкту:** 1.0.0

**Статус:** ✅ Готово до використання
