classDiagram
    %% Інтерфейси
    class ISupplyPlan {
        <<interface>>
        +executePlan() void
    }
    
    %% Абстрактний клас
    class ParticipantSupply {
        <<abstract>>
        #name: String
        +getName() String
    }
    
    %% Учасники
    class Manager {
        +createOrder(order: SupplyOrder) void
        +processReturn(order: SupplyOrder) void
    }
    
    class Supplier {
        +confirmOrder(order: SupplyOrder) void
        +issueInvoice(order: SupplyOrder) void
    }
    
    class Logistician {
        -deliveryService: DeliveryService
        +planDelivery(order: SupplyOrder) void
        +trackDelivery(order: SupplyOrder) void
        +executePlan() void
    }
    
    %% Сутності
    class SupplyOrder {
        -id: int
        -status: String
        -positions: List~OrderPosition~
        +addPosition(pos: OrderPosition) void
        +setStatus(status: String) void
        +getId() int
        +getStatus() String
        +getPositions() List
    }
    
    class OrderPosition {
        -itemName: String
        -quantity: int
        -price: double
        +getItemName() String
        +getQuantity() int
        +getPrice() double
    }
    
    class DeliveryService {
        +ship(order: SupplyOrder) void
    }
    
    %% Взаємозв'язки
    ParticipantSupply <|-- Manager
    ParticipantSupply <|-- Supplier
    ParticipantSupply <|-- Logistician
    ISupplyPlan <|.. Logistician
    
    Logistician --> DeliveryService : uses
    Manager --> SupplyOrder : creates
    Supplier --> SupplyOrder : manages
    SupplyOrder *-- OrderPosition : contains
    Logistician --> SupplyOrder : processes
    
    style ParticipantSupply fill:#fff9c4
    style ISupplyPlan fill:#f1f8e9
    style Manager fill:#e1f5fe
    style Supplier fill:#f3e5f5
    style Logistician fill:#fff3e0
    style SupplyOrder fill:#e0f2f1
    style OrderPosition fill:#ede7f6
    style DeliveryService fill:#fbe9e7
