package part06.spr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Order {

    private String clientName;
    private String product;
    private int qnt;
    private int price;

    public Order(String clientName, String product, int qnt, int price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProduct() {
        return product;
    }

    public int getQnt() {
        return qnt;
    }

    public double getPrice() {
        return price;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void save(PrintInterface printInterface){
        try {
            printInterface.save(this);
        } catch (Exception e) {
            System.out.println("Set print interface.");
        }
    }

    public void fillIn(InputInterface inputInterface) {
        inputInterface.input(this);
    }

//    public void inputFromConsole(){
//        clientName = prompt("Client name: ");
//        product = prompt("Product: ");
//        qnt = Integer.parseInt(prompt("Quantity: "));
//        price = Integer.parseInt(prompt("Price: "));
//    }
//
//    private String prompt(String message) {
//        Scanner in = new Scanner(System.in);
//        System.out.print(message);
//        return in.nextLine();
//    }

}
