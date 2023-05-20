package part06.dip;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<ReportItem> items;	// Отчетные данные

    private PrintReportInterface printReport;

    public Report(PrintReportInterface printReport) {
        this.printReport = printReport;
    }

    public Report() {}

    public void setPrintReport(PrintReportInterface printReport) {
        this.printReport = printReport;
    }

    // расчет отчетных данных
    public void calculate(){
        items =  new ArrayList<ReportItem>();
        items.add(new ReportItem("First", (float)5));
        items.add(new ReportItem("Second", (float)6));
    }

    public void output(){
        try {
            printReport.output(items);
        } catch (Exception e) {
            System.out.println("Set print report.");
        }
    }
}
