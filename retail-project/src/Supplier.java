// Постачальник - підтверджує замовлення та виставляє накладну
public class Supplier extends ParticipantSupply {

    // Конструктор
    public Supplier(String name) {
        super(name);
    }

    // Підтвердження замовлення
    public void confirmOrder(SupplyOrder order) {
        System.out.println("[Supplier '" + name + "'] Підтверджую замовлення #" + order.getId());
        order.setStatus("Confirmed");
    }

    // Виставлення накладної
    public void issueInvoice(SupplyOrder order) {
        System.out.println("[Supplier '" + name + "'] Виставляю накладну для замовлення #" + order.getId());
        order.setStatus("Invoiced");
    }
}
