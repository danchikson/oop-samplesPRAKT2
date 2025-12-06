// Головний клас, який емулює роботу системи постачання
public class Application {
    
    public static void main(String[] args) {
        System.out.println("====== СИСТЕМА РИТЕЙЛ - Імітаційний прототип ======\n");

        // Ініціалізація учасників
        DeliveryService deliveryService = new DeliveryService();
        
        Manager manager = new Manager("Іван Петренко");
        Supplier supplier = new Supplier("АБВ-Постачання");
        Logistician logistician = new Logistician("Юрій Сидоренко", deliveryService);

        // Сценарій 1: Успішне замовлення
        System.out.println("\n--- Сценарій 1: Успішне замовлення ---\n");
        
        // Менеджер створює замовлення
        SupplyOrder order1 = new SupplyOrder(1001);
        manager.createOrder(order1);
        
        // Додавання товарів до замовлення
        OrderPosition pos1 = new OrderPosition("Молоко", 10, 45.00);
        OrderPosition pos2 = new OrderPosition("Хліб", 20, 25.00);
        order1.addPosition(pos1);
        order1.addPosition(pos2);
        
        // Постачальник підтверджує замовлення
        supplier.confirmOrder(order1);
        
        // Постачальник виставляє накладну
        supplier.issueInvoice(order1);
        
        // Логіст планує доставку
        logistician.planDelivery(order1);
        logistician.trackDelivery(order1);
        
        // Відправка через DeliveryService
        logistician.executePlan();
        deliveryService.ship(order1);
        
        // Логіст змінює статус на доставлено
        order1.setStatus("Delivered");
        
        // Сценарій 2: Замовлення з поверненням
        System.out.println("\n--- Сценарій 2: Замовлення з поверненням ---\n");
        
        SupplyOrder order2 = new SupplyOrder(1002);
        manager.createOrder(order2);
        
        OrderPosition pos3 = new OrderPosition("Масло", 5, 150.00);
        OrderPosition pos4 = new OrderPosition("Сир", 8, 200.00);
        order2.addPosition(pos3);
        order2.addPosition(pos4);
        
        supplier.confirmOrder(order2);
        supplier.issueInvoice(order2);
        
        logistician.planDelivery(order2);
        logistician.executePlan();
        deliveryService.ship(order2);
        order2.setStatus("Delivered");
        
        // Менеджер оформлює повернення
        manager.processReturn(order2);
        
        // Сценарій 3: Прив'язка до UML-діаграм
        System.out.println("\n--- Сценарій 3: Демонстрація архітектури ---\n");
        System.out.println("[System] Учасники системи:");
        System.out.println("  - Manager: " + manager.getName());
        System.out.println("  - Supplier: " + supplier.getName());
        System.out.println("  - Logistician: " + logistician.getName());
        
        System.out.println("\n[System] Фінальні замовлення:");
        System.out.println("  " + order1);
        System.out.println("  " + order2);
        
        System.out.println("\n====== Імітація завершена ======");
    }
}
