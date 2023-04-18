package part01;

import java.util.List;

public class ChocolateVendingMachine {
    private final List<Product> products;

    public ChocolateVendingMachine(List<Product> products) {
        this.products = products;
    }

    public Chocolate getChocolate (String name) {
        for (Product product : products) {
            if (product instanceof Chocolate) {
                if (product.name == name) {
                    return (Chocolate)product;
                }
            }
        }
        return null;
    }
}
