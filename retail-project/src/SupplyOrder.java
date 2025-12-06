import java.util.ArrayList;
import java.util.List;

// Замовлення постачання
public class SupplyOrder {
    private int id;
    private String status;
    private List<OrderPosition> positions;

    // Конструктор
    public SupplyOrder(int id) {
        this.id = id;
        this.status = "Created";
        this.positions = new ArrayList<>();
    }

    // Методи
    public void addPosition(OrderPosition pos) {
        positions.add(pos);
        System.out.println("[SupplyOrder] Додана позиція: " + pos.getItemName());
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("[SupplyOrder] Статус замовлення #" + id + " змінено на: " + status);
    }

    // Геттери
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public List<OrderPosition> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "SupplyOrder{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", positions=" + positions +
                '}';
    }
}
