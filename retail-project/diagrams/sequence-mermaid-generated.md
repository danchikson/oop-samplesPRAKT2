sequenceDiagram
    participant M as Manager
    participant S as Supplier
    participant L as Logistician
    participant D as DeliveryService
    participant O as SupplyOrder
    
    rect rgb(200, 150, 255)
    Note over M,O: Сценарій 1: Успішне замовлення
    M->>O: createOrder()
    activate O
    O->>O: setStatus("Created")
    deactivate O
    
    M->>O: addPosition(pos1)
    M->>O: addPosition(pos2)
    
    M->>S: confirmOrder()
    activate S
    S->>O: setStatus("Confirmed")
    deactivate S
    
    S->>M: issueInvoice()
    activate M
    M->>O: setStatus("Invoiced")
    deactivate M
    end
    
    rect rgb(200, 200, 255)
    Note over L,D: Логіст планує доставку
    L->>L: planDelivery()
    L->>L: trackDelivery()
    L->>L: executePlan()
    L->>D: ship(order)
    activate D
    D->>O: setStatus("Shipped")
    deactivate D
    end
    
    rect rgb(150, 200, 255)
    Note over M,O: Сценарій 2: Повернення
    alt Якщо проблема з товаром
        M->>O: processReturn()
        O->>O: setStatus("Returned")
    end
    end
    
    rect rgb(255, 200, 150)
    Note over M,O: Замовлення завершено
    O->>O: setStatus("Delivered")
    end
