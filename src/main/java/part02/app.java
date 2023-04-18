package part02;

public class app {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик", 5);
        Cat cat2 = new Cat("Персик", 7);
        Cat cat3 = new Cat("Мурка", 4);
        Cat cat4 = new Cat("Жорик", 9);
        Cat cat5 = new Cat("Пушок", 6);
        Cat cat6 = new Cat("Фиса", 7);

        Plate plate1 = new Plate(30);
        plate1.info();

        Cat[] cats = new Cat[] {cat1, cat2, cat3, cat4, cat5, cat6};

        feedCats(cats, plate1);
        isWellFed(cats);

        plate1.addFood(5);
        System.out.println("");

        feedCats(cats, plate1);
        plate1.info();
        isWellFed(cats);
    }
    public static void feedCats(Cat[] cats, Plate plate) {
        for (Cat cat: cats) {
            if (cat.eat(plate)) {
                System.out.println(cat.getName() + " съел " + cat.getAppetite() + "кусочков.");
            } else if (!cat.isWellFed())
                System.out.println(cat.getName() + " хочет кушать!");
            else
                System.out.println(cat.getName() + ": Мурррр! Я сыт!");
        }
    }
    public static void isWellFed(Cat[] cats) {
        for (Cat cat: cats) {
            if (cat.isWellFed()) {
                System.out.println(String.format("%s сыт!", cat.getName()));
            } else
                System.out.println(String.format("%s голоден!", cat.getName()));
        }
    }
}
