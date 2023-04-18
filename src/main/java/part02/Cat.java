package part02;

import javax.swing.*;

public class Cat {
    private String name;
    private int appetite;
    private boolean isWellFed;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isWellFed = false;
    }
    public boolean eat(Plate plate) {
        if (!isWellFed) {
            if (plate.getFood() - this.appetite >=0) {
                plate.setFood(plate.getFood() - this.appetite);
                this.isWellFed = !this.isWellFed;
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isWellFed() {
        return isWellFed;
    }
}
