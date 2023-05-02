package part04;

/**
 * a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
 * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
 * подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * g. Не забываем про метод добавления фрукта в коробку.
 */

public class App {
    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>(Apple.class);
        Box<Apple> appleBox2 = new Box<>(Apple.class);
        Box<Orange> orangeBox1 = new Box<>(Orange.class);
        Box<Orange> orangeBox2 = new Box<>(Orange.class);
        Box<Orange> orangeBox3 = new Box<>(Orange.class);

//        FILLING THE APPLEBOX#1
        for (int i = 0; i < 20; i++) {
            appleBox1.addFruit(new Apple());
        }

//        FILLING THE APPLEBOX#2
        for (int i = 0; i < 108; i++) {
            appleBox2.addFruit(new Apple());
        }

//        FILLING THE ORANGEBOX#1
        for (int i = 0; i < 72; i++) {
            orangeBox1.addFruit(new Orange());
        }

//        FILLING THE ORANGEBOX#2
        for (int i = 0; i < 130; i++) {
            orangeBox2.addFruit(new Orange());
        }
        System.out.println();

//        COMPARE FEW BOXES
        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox2.compare(orangeBox1));
        System.out.println();

//        INFO ABOUT BOXES
        System.out.println(appleBox1);
        System.out.println(appleBox2);
        System.out.println(orangeBox1);
        System.out.println(orangeBox2);
        System.out.println(orangeBox3);

        System.out.println();
        orangeBox3.transferFruits(orangeBox2, 1);
        orangeBox3.transferFruits(orangeBox2);
        System.out.println();
        orangeBox2.transferFruits(orangeBox3, 3);
        System.out.println();
        orangeBox2.transferFruits(orangeBox3, 300);
        System.out.println();
        orangeBox3.transferFruits(orangeBox2);

    }
}