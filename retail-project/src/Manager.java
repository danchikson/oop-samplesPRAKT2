// Менеджер магазину - створює замовлення та оформлює повернення
public class Manager extends ParticipantSupply {

    // Конструктор
    public Manager(String name) {
        super(name);
    }

    // Створення замовлення
    public void createOrder(SupplyOrder order) {
        System.out.println("[Manager '" + name + "'] Створено замовлення #" + order.getId());
        order.setStatus("Created");
    }

    // Оформлення повернення
    public void processReturn(SupplyOrder order) {
        System.out.println("[Manager '" + name + "'] Оформляю повернення замовлення #" + order.getId());
        order.setStatus("Returned");
    }
}
