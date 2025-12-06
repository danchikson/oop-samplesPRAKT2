```mermaid
%% Class Diagram - Система Ритейл
graph TB
    %% Інтерфейс
    ISupplyPlan["<<interface>><br/>ISupplyPlan<br/>__<br/>+ executePlan(): void"]

    %% Абстрактний клас
    ParticipantSupply["<<abstract>><br/>ParticipantSupply<br/>__<br/>- name: String<br/>+ getName(): String"]

    %% Конкретні класи
    Manager["Manager<br/>__<br/>+ createOrder(order): void<br/>+ processReturn(order): void"]
    Supplier["Supplier<br/>__<br/>+ confirmOrder(order): void<br/>+ issueInvoice(order): void"]
    Logistician["Logistician<br/>__<br/>- deliveryService: DeliveryService<br/>+ planDelivery(order): void<br/>+ trackDelivery(order): void<br/>+ executePlan(): void"]

    %% Бізнес-сутності
    SupplyOrder["SupplyOrder<br/>__<br/>- id: int<br/>- status: String<br/>- positions: List&lt;OrderPosition&gt;<br/>__<br/>+ addPosition(pos): void<br/>+ setStatus(status): void<br/>+ getId(): int<br/>+ getStatus(): String<br/>+ getPositions(): List"]
    OrderPosition["OrderPosition<br/>__<br/>- itemName: String<br/>- quantity: int<br/>- price: double<br/>__<br/>+ getItemName(): String<br/>+ getQuantity(): int<br/>+ getPrice(): double"]

    %% Служби
    DeliveryService["DeliveryService<br/>__<br/>+ ship(order): void"]

    %% Відносини спадкування
    Manager -->|extends| ParticipantSupply
    Supplier -->|extends| ParticipantSupply
    Logistician -->|extends| ParticipantSupply
    Logistician -->|implements| ISupplyPlan

    %% Відносини композиції та залежності
    SupplyOrder -->|contains *| OrderPosition
    Logistician -->|uses| DeliveryService
    Manager -.->|creates| SupplyOrder
    Supplier -.->|modifies| SupplyOrder
    Logistician -.->|modifies| SupplyOrder

    %% Стилі
    style ISupplyPlan fill:#fff59d,stroke:#f57f17,stroke-width:2px
    style ParticipantSupply fill:#f0f4c3,stroke:#9ccc65,stroke-width:2px
    style Manager fill:#c8e6c9,stroke:#2e7d32,stroke-width:2px
    style Supplier fill:#c8e6c9,stroke:#2e7d32,stroke-width:2px
    style Logistician fill:#c8e6c9,stroke:#2e7d32,stroke-width:2px
    style SupplyOrder fill:#bbdefb,stroke:#1565c0,stroke-width:2px
    style OrderPosition fill:#bbdefb,stroke:#1565c0,stroke-width:2px
    style DeliveryService fill:#ffccbc,stroke:#d84315,stroke-width:2px
```
