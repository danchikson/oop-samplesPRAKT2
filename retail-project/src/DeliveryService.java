// Служба доставки
public class DeliveryService {
    
    // Метод для відправки замовлення
    public void ship(SupplyOrder order) {
        System.out.println("[DeliveryService] Замовлення #" + order.getId() + " відправлено на доставку");
        System.out.println("[DeliveryService] Номер відстеження: DLV-" + order.getId() + "-" + System.currentTimeMillis());
    }
}
