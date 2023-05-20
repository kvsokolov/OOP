package part06.spr;

public class Program {

    //TODO: (Домашняя работа: 1) Сохранить заказ в XML документ
    public static void main(String[] args) {
        System.out.println("Введите заказ:");
        Order order = new Order("", "", 0, 0);
        order.fillIn(new ConsoleInput());
        order.save(new SaveToXML());
        order.save(new SaveToJSON());

    }

}
