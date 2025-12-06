// Логіст - планує доставку та відстежує її
public class Logistician extends ParticipantSupply implements ISupplyPlan {
    private DeliveryService deliveryService;

    // Конструктор
    public Logistician(String name, DeliveryService deliveryService) {
        super(name);
        this.deliveryService = deliveryService;
    }

    // Планування доставки
    public void planDelivery(SupplyOrder order) {
        System.out.println("[Logistician '" + name + "'] Планую доставку замовлення #" + order.getId());
    }

    // Відстеження доставки
    public void trackDelivery(SupplyOrder order) {
        System.out.println("[Logistician '" + name + "'] Відслідковую доставку замовлення #" + order.getId());
    }

    // Реалізація методу інтерфейсу ISupplyPlan
    @Override
    public void executePlan() {
        System.out.println("[Logistician '" + name + "'] Виконую план постачання");
    }
}
