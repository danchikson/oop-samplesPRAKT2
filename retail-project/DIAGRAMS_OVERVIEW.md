# 🎨 Mermaid діаграми - Швидкий перегляд

> Цей файл містить всі Mermaid діаграми в одному місці для швидкого перегляду та порівняння

---

## 1️⃣ Use Case Diagram

**Файл:** [diagrams/usecase-mermaid.md](diagrams/usecase-mermaid.md)

```mermaid
graph TB
    Manager["👤 Менеджер магазину"]
    Supplier["👤 Постачальник"]
    Logistician["👤 Логіст"]

    subgraph UseCases ["Система Ритейл"]
        UC1["📝 Створити замовлення"]
        UC2["✓ Підтвердити замовлення"]
        UC3["📄 Виставити накладну"]
        UC4["📦 Планувати доставку"]
        UC5["🔍 Відстежити доставку"]
        UC6["↩️  Оформити повернення"]
    end

    Manager -->|Виконує| UC1
    Manager -->|Виконує| UC6
    Supplier -->|Виконує| UC2
    Supplier -->|Виконує| UC3
    Logistician -->|Виконує| UC4
    Logistician -->|Виконує| UC5

    UC1 -.->|включає| UC2
    UC2 -.->|включає| UC3
    UC3 -.->|включає| UC4
    UC4 -.->|пов'язана| UC5

    style Manager fill:#e1f5ff
    style Supplier fill:#e1f5ff
    style Logistician fill:#e1f5ff
    style UseCases fill:#fff9c4
    style UC1 fill:#c8e6c9
    style UC2 fill:#c8e6c9
    style UC3 fill:#c8e6c9
    style UC4 fill:#c8e6c9
    style UC5 fill:#c8e6c9
    style UC6 fill:#ffccbc
```

---

## 2️⃣ Class Diagram

**Файл:** [diagrams/class-mermaid.md](diagrams/class-mermaid.md)

```mermaid
graph TB
    ISupplyPlan["<<interface>><br/>ISupplyPlan<br/>__<br/>+ executePlan(): void"]

    ParticipantSupply["<<abstract>><br/>ParticipantSupply<br/>__<br/>- name: String<br/>+ getName(): String"]

    Manager["Manager<br/>__<br/>+ createOrder(order): void<br/>+ processReturn(order): void"]
    Supplier["Supplier<br/>__<br/>+ confirmOrder(order): void<br/>+ issueInvoice(order): void"]
    Logistician["Logistician<br/>__<br/>- deliveryService: DeliveryService<br/>+ planDelivery(order): void<br/>+ trackDelivery(order): void<br/>+ executePlan(): void"]

    SupplyOrder["SupplyOrder<br/>__<br/>- id: int<br/>- status: String<br/>- positions: List&lt;OrderPosition&gt;<br/>__<br/>+ addPosition(pos): void<br/>+ setStatus(status): void<br/>+ getId(): int<br/>+ getStatus(): String<br/>+ getPositions(): List"]
    OrderPosition["OrderPosition<br/>__<br/>- itemName: String<br/>- quantity: int<br/>- price: double<br/>__<br/>+ getItemName(): String<br/>+ getQuantity(): int<br/>+ getPrice(): double"]

    DeliveryService["DeliveryService<br/>__<br/>+ ship(order): void"]

    Manager -->|extends| ParticipantSupply
    Supplier -->|extends| ParticipantSupply
    Logistician -->|extends| ParticipantSupply
    Logistician -->|implements| ISupplyPlan

    SupplyOrder -->|contains *| OrderPosition
    Logistician -->|uses| DeliveryService
    Manager -.->|creates| SupplyOrder
    Supplier -.->|modifies| SupplyOrder
    Logistician -.->|modifies| SupplyOrder

    style ISupplyPlan fill:#fff59d,stroke:#f57f17,stroke-width:2px
    style ParticipantSupply fill:#f0f4c3,stroke:#9ccc65,stroke-width:2px
    style Manager fill:#c8e6c9,stroke:#2e7d32,stroke-width:2px
    style Supplier fill:#c8e6c9,stroke:#2e7d32,stroke-width:2px
    style Logistician fill:#c8e6c9,stroke:#2e7d32,stroke-width:2px
    style SupplyOrder fill:#bbdefb,stroke:#1565c0,stroke-width:2px
    style OrderPosition fill:#bbdefb,stroke:#1565c0,stroke-width:2px
    style DeliveryService fill:#ffccbc,stroke:#d84315,stroke-width:2px
```

---

## 3️⃣ Sequence Diagram - Сценарій 1 (Успішне замовлення)

**Файл:** [diagrams/sequence-scenario1-mermaid.md](diagrams/sequence-scenario1-mermaid.md)

```mermaid
sequenceDiagram
    participant Manager as Менеджер
    participant SO as SupplyOrder
    participant Supplier as Постачальник
    participant Logistician as Логіст
    participant DeliveryService as Служба доставки

    rect rgb(100, 150, 200)
        Note over Manager,DeliveryService: Сценарій 1: Успішне замовлення
    end

    Manager->>SO: createOrder()
    activate SO
    SO-->>Manager: статус = "Created"
    deactivate SO

    Manager->>SO: addPosition("Молоко", 10, 45.00)
    Manager->>SO: addPosition("Хліб", 20, 25.00)

    Supplier->>SO: confirmOrder()
    activate SO
    SO-->>Supplier: статус = "Confirmed"
    deactivate SO

    Supplier->>SO: issueInvoice()
    activate SO
    SO-->>Supplier: статус = "Invoiced"
    deactivate SO

    Logistician->>SO: planDelivery()
    Logistician->>SO: trackDelivery()

    Logistician->>Logistician: executePlan()
    activate Logistician
    Note over Logistician: Реалізація ISupplyPlan
    deactivate Logistician

    Logistician->>DeliveryService: ship(order)
    activate DeliveryService
    DeliveryService-->>Logistician: trackingNumber
    deactivate DeliveryService

    SO->>SO: setStatus("Delivered")
    activate SO
    SO-->>Logistician: статус = "Delivered"
    deactivate SO
```

---

## 4️⃣ Sequence Diagram - Сценарій 2 (Замовлення з поверненням)

**Файл:** [diagrams/sequence-scenario2-mermaid.md](diagrams/sequence-scenario2-mermaid.md)

```mermaid
sequenceDiagram
    participant Manager as Менеджер
    participant SO as SupplyOrder
    participant Supplier as Постачальник
    participant Logistician as Логіст
    participant DeliveryService as Служба доставки

    rect rgb(200, 150, 100)
        Note over Manager,DeliveryService: Сценарій 2: Замовлення з поверненням
    end

    Manager->>SO: createOrder()
    activate SO
    SO-->>Manager: статус = "Created"
    deactivate SO

    Manager->>SO: addPosition("Масло", 5, 150.00)
    Manager->>SO: addPosition("Сир", 8, 200.00)

    Supplier->>SO: confirmOrder()
    activate SO
    SO-->>Supplier: статус = "Confirmed"
    deactivate SO

    Supplier->>SO: issueInvoice()
    activate SO
    SO-->>Supplier: статус = "Invoiced"
    deactivate SO

    Logistician->>SO: planDelivery()
    Logistician->>Logistician: executePlan()
    activate Logistician
    Note over Logistician: Реалізація ISupplyPlan
    deactivate Logistician

    Logistician->>DeliveryService: ship(order)
    activate DeliveryService
    DeliveryService-->>Logistician: trackingNumber
    deactivate DeliveryService

    SO->>SO: setStatus("Delivered")

    rect rgb(255, 200, 100)
        Note over Manager: Виявлена проблема з товаром
    end

    Manager->>SO: processReturn()
    activate SO
    SO-->>Manager: статус = "Returned"
    deactivate SO
```

---

## 5️⃣ State Diagram

**Файл:** [diagrams/state-mermaid.md](diagrams/state-mermaid.md)

```mermaid
graph TD
    Start["🟢 START"]
    Created["Created<br/>Менеджер створює замовлення"]
    Confirmed["Confirmed<br/>Постачальник підтверджує"]
    Invoiced["Invoiced<br/>Постачальник виставляє накладну"]
    Shipping["Shipping<br/>Логіст планує доставку"]
    Delivered["Delivered<br/>Доставка завершена"]
    Returned["Returned<br/>Менеджер оформлює повернення"]
    End["🔴 END"]

    Start -->|createOrder| Created
    Created -->|confirmOrder| Confirmed
    Confirmed -->|issueInvoice| Invoiced
    Invoiced -->|planDelivery + ship| Shipping
    Shipping -->|setStatus| Delivered
    Delivered -->|SUCCESS| End
    Delivered -->|PROBLEM| Returned
    Returned -->|END| End

    style Start fill:#90ee90,stroke:#228b22,stroke-width:3px
    style Created fill:#87ceeb,stroke:#1e90ff,stroke-width:2px
    style Confirmed fill:#87ceeb,stroke:#1e90ff,stroke-width:2px
    style Invoiced fill:#87ceeb,stroke:#1e90ff,stroke-width:2px
    style Shipping fill:#ffd700,stroke:#ff8c00,stroke-width:2px
    style Delivered fill:#98fb98,stroke:#228b22,stroke-width:2px
    style Returned fill:#ff6b6b,stroke:#d32f2f,stroke-width:2px
    style End fill:#ff6b6b,stroke:#d32f2f,stroke-width:3px
```

---

## 📊 Порівняння з PlantUML

### Таблиця еквівалентності

| PlantUML | Mermaid | Статус |
|----------|---------|--------|
| [docs/usecase.puml](docs/usecase.puml) | [diagrams/usecase-mermaid.md](diagrams/usecase-mermaid.md) | ✓ 100% еквівалент |
| [docs/class.puml](docs/class.puml) | [diagrams/class-mermaid.md](diagrams/class-mermaid.md) | ✓ 95% еквівалент + доповнення |
| [docs/sequence.puml](docs/sequence.puml) | [diagrams/sequence-scenario1-mermaid.md](diagrams/sequence-scenario1-mermaid.md) | ⚠️ 90% + більше деталей |
| N/A | [diagrams/sequence-scenario2-mermaid.md](diagrams/sequence-scenario2-mermaid.md) | ✓ НОВИЙ: Сценарій 2 |
| [docs/state.puml](docs/state.puml) | [diagrams/state-mermaid.md](diagrams/state-mermaid.md) | ✓ 100% еквівалент |

---

## 🔍 Ключові покращення Mermaid версій

### 1. **Use Case Diagram**
- ✓ Додано візуальні іконки (👤, 📝, ✓, 📄, 📦, 🔍, ↩️)
- ✓ Кольорове кодування
- ✓ Чіткіша читаність

### 2. **Class Diagram**
- ✓ Додано явно атрибут `deliveryService` в Logistician
- ✓ Додано явно методи-гетери в SupplyOrder та OrderPosition
- ✓ Кольорове розрізнення типів класів
- ✓ Чіткіше позначення залежностей

### 3. **Sequence Diagram - Сценарій 1**
- ✓ Додано явно виклики `addPosition()`
- ✓ Додано явно виклик `trackDelivery()`
- ✓ Додано явно виклик `executePlan()`
- ✓ Кольорові прямокутники для різних фаз
- ✓ Видно активацію об'єктів

### 4. **Sequence Diagram - Сценарій 2**
- ✓ **НОВИЙ:** Повна діаграма для сценарію з поверненням
- ✓ Показує альтернативний шлях обробки
- ✓ Демонструє решення з процесом повернення

### 5. **State Diagram**
- ✓ Додано кольорові акценти для різних типів переходів
- ✓ Розгалуження представлено з параметрами (SUCCESS/PROBLEM)
- ✓ Чітке розрізнення початку та кінця
- ✓ Явні імена переходів

---

## 💡 Рекомендації щодо використання

### Для GitHub README
Рекомендується вбудовувати Mermaid діаграми прямо у README.md через GitHub's native підтримку:

```markdown
## Architecture

### Use Case Diagram
[вбудована діаграма]

### Class Diagram
[вбудована діаграма]

### Workflows
[Sequence діаграми]

### Order State Machine
[State діаграма]
```

### Для локального перегляду
1. Використовуйте GitHub щоб переглянути Mermaid
2. Або встановіть Mermaid Live Editor: https://mermaid.live

### Для документації
Розглянути додавання обох версій (PlantUML + Mermaid) для:
- PlantUML - формальна документація
- Mermaid - GitHub-friendly версія

---

## 📚 Посилання

| Діаграма | PlantUML | Mermaid |
|----------|----------|---------|
| Use Case | [docs/usecase.puml](docs/usecase.puml) | [diagrams/usecase-mermaid.md](diagrams/usecase-mermaid.md) |
| Class | [docs/class.puml](docs/class.puml) | [diagrams/class-mermaid.md](diagrams/class-mermaid.md) |
| Sequence | [docs/sequence.puml](docs/sequence.puml) | [diagrams/sequence-scenario1-mermaid.md](diagrams/sequence-scenario1-mermaid.md) |
| State | [docs/state.puml](docs/state.puml) | [diagrams/state-mermaid.md](diagrams/state-mermaid.md) |
| Scenario 2 | N/A | [diagrams/sequence-scenario2-mermaid.md](diagrams/sequence-scenario2-mermaid.md) |

---

**Дата створення:** 6 грудня 2025
**Статус:** ✅ Готово
**Кількість діаграм:** 5 Mermaid + 4 PlantUML = 9 всього
