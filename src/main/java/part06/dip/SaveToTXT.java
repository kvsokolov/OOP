package part06.dip;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveToTXT implements PrintReportInterface {

    @Override
    public void output(List<ReportItem> items) {
        try {
            StringBuilder report = new StringBuilder();
            for (ReportItem item : items) {
                report.append( String.format("printer %s - %f \n\r", item.getDescription(), item.getAmount()));
            }
            FileWriter myWriter = new FileWriter("./src/main/java/part06/dip/Report.txt");
            myWriter.write(report.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
