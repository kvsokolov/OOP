package part02;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if(this.food - food < 0)
            System.out.println("Еды не хватает");
        else
            this.food = food;
    }

    public String addFood(int food) {
        this.food += food;
        return String.format("Было добавлено %d кусочков, теперь в миске %d кусочков!", food, this.food);
    }
}
