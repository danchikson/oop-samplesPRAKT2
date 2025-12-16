stateDiagram-v2
    [*] --> Created : Manager створює
    
    state Created {
        [*] --> Init
        Init --> Adding : addPosition()
        Adding --> Ready : позиції додані
    }
    
    Created --> Confirmed : Supplier підтверджує
    
    state Confirmed {
        [*] --> Confirm
    }
    
    Confirmed --> Invoiced : Supplier виставляє накладну
    
    state Invoiced {
        [*] --> Invoice
    }
    
    Invoiced --> Shipping : Logistician планує доставку
    
    state Shipping {
        [*] --> Planning
        Planning --> Tracking : logistician.executePlan()
        Tracking --> InTransit : DeliveryService.ship()
    }
    
    Shipping --> Delivered : Доставка завершена
    
    state Delivered {
        [*] --> Delivered
    }
    
    Delivered --> Returned : Manager оформлює повернення
    Delivered --> [*] : Успішне завершення
    
    Returned --> [*] : Повернення оброблено
    
    note right of Created
        Статус: "Created"
        Дії: createOrder(), addPosition()
    end note
    
    note right of Confirmed
        Статус: "Confirmed"
        Дія: confirmOrder()
    end note
    
    note right of Invoiced
        Статус: "Invoiced"
        Дія: issueInvoice()
    end note
    
    note right of Shipping
        Статус: "Shipped"/"InTransit"
        Дії: planDelivery(), trackDelivery(), ship()
    end note
    
    note right of Delivered
        Статус: "Delivered"
        Завершення замовлення
    end note
    
    note right of Returned
        Статус: "Returned"
        Дія: processReturn()
    end note
