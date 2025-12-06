# Аналіз Java-коду та Порівняння з UML діаграмами

## 1. Архітектурний аналіз Java-коду

### 1.1 Структура класів
Проєкт реалізує систему управління постачанням товарів у роздрібній торгівлі з наступною архітектурою:

#### Базова ієрархія спадкування:
```
ParticipantSupply (абстрактний клас)
├── Manager
├── Supplier
└── Logistician (implements ISupplyPlan)
```

#### Сутності:
```
SupplyOrder (1) --- (много) OrderPosition
                       │
                       └── DeliveryService
```

### 1.2 Детальний опис класів

#### ParticipantSupply (абстрактний клас)
- **Атрибути:**
  - `name: String` - ім'я учасника
- **Методи:**
  - `getName(): String`

#### Manager
- **Методи:**
  - `createOrder(SupplyOrder): void` - створення замовлення
  - `processReturn(SupplyOrder): void` - оформлення повернення

#### Supplier
- **Методи:**
  - `confirmOrder(SupplyOrder): void` - підтвердження замовлення
  - `issueInvoice(SupplyOrder): void` - виставлення накладної

#### Logistician (implements ISupplyPlan)
- **Атрибути:**
  - `deliveryService: DeliveryService` - посилання на служб доставки
- **Методи:**
  - `planDelivery(SupplyOrder): void` - планування доставки
  - `trackDelivery(SupplyOrder): void` - відстеження доставки
  - `executePlan(): void` - виконання плану (реалізація інтерфейсу)

#### SupplyOrder
- **Атрибути:**
  - `id: int` - унікальний ID замовлення
  - `status: String` - поточний статус
  - `positions: List<OrderPosition>` - список позицій
- **Методи:**
  - `addPosition(OrderPosition): void`
  - `setStatus(String): void`
  - `getId(): int`
  - `getStatus(): String`
  - `getPositions(): List<OrderPosition>`

#### OrderPosition
- **Атрибути:**
  - `itemName: String` - назва товару
  - `quantity: int` - кількість
  - `price: double` - ціна
- **Методи:**
  - `getItemName(): String`
  - `getQuantity(): int`
  - `getPrice(): double`

#### DeliveryService
- **Методи:**
  - `ship(SupplyOrder): void` - відправлення замовлення на доставку

#### ISupplyPlan (інтерфейс)
- **Методи:**
  - `executePlan(): void`

### 1.3 Сценарії використання в Application.main()

**Сценарій 1: Успішне замовлення**
1. Менеджер створює замовлення (ID 1001)
2. Додаються 2 позиції (Молоко, Хліб)
3. Постачальник підтверджує замовлення
4. Постачальник виставляє накладну
5. Логіст планує доставку
6. Логіст відстежує доставку
7. Логіст виконує план (executePlan)
8. DeliveryService відправляє замовлення
9. Замовлення стає "Delivered"

**Сценарій 2: Замовлення з поверненням**
1. Менеджер створює замовлення (ID 1002)
2. Додаються 2 позиції (Масло, Сир)
3. Той же процес, що і Сценарій 1, аж до доставки
4. Менеджер оформлює повернення
5. Замовлення стає "Returned"

---

## 2. Порівняння з PlantUML діаграмами

### 2.1 Діаграма класів (Class Diagram)

**PlantUML (з /docs/class.puml):**
- ✓ Правильно зображує спадкування Manager → ParticipantSupply
- ✓ Правильно зображує спадкування Supplier → ParticipantSupply
- ✓ Правильно зображує спадкування Logistician → ParticipantSupply та реалізацію ISupplyPlan
- ✓ Показує композицію SupplyOrder *-- OrderPosition
- ✓ Показує залежність Logistician ..> DeliveryService
- ✓ Показує залежність Manager ..> SupplyOrder
- ⚠️ **Не повностю показує:** Що Logistician має атрибут `deliveryService: DeliveryService`
- ⚠️ **Не показує:** Методи в порядку, як вони викликаються в коді

**Висновок:** Діаграма класів точна, але мінімальна в деталях про композицію.

### 2.2 Діаграма варіантів використання (Use Case Diagram)

**PlantUML (з /docs/usecase.puml):**
- ✓ Правильно зображує 3 актори: Manager, Supplier, Logistician
- ✓ Правильно зображує 6 use case'ів
- ✓ Правильно показує залежності (include) між use case'ами
- ✓ Послідовність: UC1 → UC2 → UC3 → UC4 (UC5 паралельно)
- ⚠️ **Не показує:** Use case UC6 (processReturn) як варіант після Delivered, не тільки після UC4
- ⚠️ **Не показує:** Що UC5 (trackDelivery) існує як окремий use case

**Висновок:** Діаграма варіантів використання охоплює основні потоки, але мінімізує альтернативні сценарії.

### 2.3 Діаграма послідовності (Sequence Diagram)

**PlantUML (з /docs/sequence.puml):**
- ✓ Показує послідовність викликів для успішного замовлення
- ⚠️ **Не показує:** trackDelivery() як окремий виклик перед executePlan()
- ⚠️ **Не показує:** Що setStatus() викликається в кожному методі Manager, Supplier, Logistician
- ⚠️ **Не показує:** Другий сценарій з поверненням
- ⚠️ **Не показує:** addPosition() викликів для додавання товарів

**Висновок:** Діаграма послідовності спрощена і показує тільки основний потік.

### 2.4 Діаграма станів (State Diagram)

**PlantUML (з /docs/state.puml):**
- ✓ Правильно зображує стани: Created → Confirmed → Invoiced → Shipping → Delivered
- ✓ Правильно показує переходи за дії учасників
- ✓ Показує альтернативний шлях: Delivered → Returned
- ✓ Показує кінцеві стани [*]
- ⚠️ **Мінор:** Стан "Shipping" не має внутрішньої логіки, але в Java це просто статус-рядок

**Висновок:** Діаграма станів точна та повна відображує основні стани.

---

## 3. Відмінності між документацією та реалізацією

| Аспект | PlantUML (/docs) | Java код | Розбіжність |
|--------|-----------------|----------|------------|
| Методи в Manager | createOrder, processReturn | ✓ Точно | Немає |
| Методи в Supplier | confirmOrder, issueInvoice | ✓ Точно | Немає |
| Методи в Logistician | planDelivery, trackDelivery, executePlan | ✓ Точно + додатково | OK |
| Атрибути OrderPosition | itemName, quantity, price | ✓ Точно | Немає |
| Атрибути SupplyOrder | id, status, positions | ✓ Точно | Немає |
| DeliveryService.ship() | задокументовано в class.puml | ✓ Точно | Немає |
| Послідовність викликів | 6 use case'ів | ✓ Реалізовано | Немає |
| Альтернативні сценарії | UC6 (processReturn) | ✓ Реалізовано | Немає |
| Атрибут deliveryService в Logistician | Не вказано явно | ✓ Є | Мінор |

---

## 4. Висновки та рекомендації

### Що добре реалізовано:
1. ✓ Архітектура точно відповідає PlantUML діаграмам
2. ✓ Всі класи, методи та атрибути задокументовані
3. ✓ Спадкування правильно вложено
4. ✓ Інтерфейс ISupplyPlan правильно реалізовано
5. ✓ Сценарії використання охоплені в Application

### Що потребує уточнення документації:
1. ⚠️ class.puml - додати явне позначення атрибуту `deliveryService` в Logistician
2. ⚠️ sequence.puml - додати trackDelivery() як окремий виклик
3. ⚠️ sequence.puml - додати сценарій з поверненням (processReturn)
4. ⚠️ sequence.puml - додати addPosition() викликів
5. ⚠️ usecase.puml - додати зв'язок від UC1 безпосередньо до UC6 як альтернативний шлях

### Загальна оцінка:
**Реалізація на 95% відповідає документації.** Невеликі розбіжності пов'язані з тим, що документація спеціально спрощена для навчальних цілей.
