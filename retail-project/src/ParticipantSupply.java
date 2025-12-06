// Абстрактний клас учасника постачання
public abstract class ParticipantSupply {
    protected String name;

    // Конструктор
    public ParticipantSupply(String name) {
        this.name = name;
    }

    // Метод для отримання імені
    public String getName() {
        return name;
    }
}
