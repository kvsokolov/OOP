package part04;

import java.util.ArrayList;

class Box<T extends Fruit> {
    private static int count;
    private final int id;
    private final Class<T> type;
    ArrayList<T> fruits;

    {
        count++;
        id = count;
        fruits = new ArrayList<>();
    }

    public int getId() {
        return id;
    }


    public Box(Class<T> type, ArrayList<T> fruits) {
        this.fruits = fruits;
        this.type = type;
    }

    public Box(Class<T> type) {
        this.type = type;
    }

    public float getBoxWeight() {
        if (fruits.isEmpty())
            return 0;
        else return fruits.size() * fruits.get(0).getWeight();
    }

    public void addFruit(T fruit) {
        if (fruit.isInBox()) {
            System.out.printf("The %s have already been put in box #%d. Try another one fruit.\n",
                    fruit.getClass().getSimpleName().toLowerCase(), fruit.getLocation());
        } else {
            fruits.add(fruit);
            fruit.setInBox(true);
            fruit.setLocation(this.getId());
//            System.out.printf("The %s have been put into box #%d\n",
//                    fruit.getClass().getSimpleName().toLowerCase(), this.getId());
        }
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getBoxWeight() == box.getBoxWeight();
    }

    public void transferFruits(Box<T> toBox) {
        if (this.fruits.isEmpty())
            System.out.printf("The box of %ss #%d is empty.\n", type.getSimpleName().toLowerCase(), this.id);
        else {
            toBox.fruits.addAll(this.fruits);
            this.fruits.clear();
            System.out.println("Transfer have been completed successfully.\nActual information about boxes:");
            System.out.println(this);
            System.out.println(toBox);
        }
    }

    public void transferFruits(Box<T> toBox, int amount) {
        if (this.fruits.isEmpty())
            System.out.printf("The box of %ss #%d is empty.\n", type.getSimpleName().toLowerCase(), this.id);
        else {
            if (amount >= this.fruits.size()) {
                System.out.println("There are not enough oranges in the box, we have moved all the remaining ones.");
                transferFruits(toBox);
            } else {
                for (int i = 0; i < amount; i++) {
                    toBox.fruits.add(this.fruits.get(0));
                    this.fruits.remove(0);
                }
                System.out.println("Transfer have been completed successfully.\nActual information about boxes:");
                System.out.println(this);
                System.out.println(toBox);
            }
        }
    }


    @Override
    public String toString() {
        if (fruits.isEmpty())
            return String.format("The box of %ss #%d is empty.", type.getSimpleName().toLowerCase(), this.getId());
        else
            return String.format("The box of %ss #%d contains %d %ss. It's weight is %.1f kg",
                    type.getSimpleName().toLowerCase(), this.getId(), fruits.size(),
                    type.getSimpleName().toLowerCase(), this.getBoxWeight());
    }
}