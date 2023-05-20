package part06.spr;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToXML implements PrintInterface {

    @Override
    public void save(Order order) {
        String fileName = "./src/main/java/part06/spr/order.xml";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>");
            writer.write("\t<clientName>" + order.getClientName() + "</clientName>\n");
            writer.write("\t<product>" + order.getProduct() + "</product>\n");
            writer.write("\t<qnt>" + order.getQnt() + "</qnt>\n");
            writer.write("\t<price>" + order.getPrice() + "</price>\n</root>\n");
            writer.write("\n");
            writer.flush();
            System.out.println("File order.xml has been written successfully.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
