package part01;

public class Chocolate extends Product {

    private int weight;
    private int energy;

    public Chocolate (String name, double price, int weight, int energy) {
        super(name, price);
        this.weight = weight;
        this.energy = energy;
    }

    public int getWeight() {
        return weight;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    String displayInfo() {
        return String.format("Бренд: %s;\nНаименование: %s;\nЦена: %f рублей;\nВес: " +
                "%d грамм;\nКалорийность: %d ккал.", brand, name, price, weight, energy);
    }
}
