package part06.spr;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToJSON implements PrintInterface {

    @Override
    public void save(Order order) {
        String fileName = "./src/main/java/part06/spr/order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
            writer.write("\"product\":\"" + order.getProduct() + "\",\n");
            writer.write("\"qnt\":" + order.getQnt() + ",\n");
            writer.write("\"price\":" + order.getPrice() + "\n");
            writer.write("}\n");
            writer.flush();
            System.out.println("File order.json has been written successfully.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
