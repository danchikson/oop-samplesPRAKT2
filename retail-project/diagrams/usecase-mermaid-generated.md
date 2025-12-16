graph TB
    User["👤 User"]
    
    subgraph "Система Ритейл"
        Manager["📋 Manage Orders<br/>(Manager)"]
        Confirm["✓ Confirm Order<br/>(Supplier)"]
        Invoice["📄 Issue Invoice<br/>(Supplier)"]
        Plan["📦 Plan Delivery<br/>(Logistician)"]
        Track["🚚 Track Delivery<br/>(Logistician)"]
        Return["↩️ Process Return<br/>(Manager)"]
    end
    
    User -->|Create Order| Manager
    Manager -->|Confirm| Confirm
    Confirm -->|Invoice| Invoice
    Invoice -->|Plan Delivery| Plan
    Plan -->|Track| Track
    Track -->|If Problem| Return
    
    style Manager fill:#e1f5ff
    style Confirm fill:#f3e5f5
    style Invoice fill:#f3e5f5
    style Plan fill:#fff3e0
    style Track fill:#fff3e0
    style Return fill:#ffebee
