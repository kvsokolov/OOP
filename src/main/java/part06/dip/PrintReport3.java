package part06.dip;

import java.util.List;

public class PrintReport3 implements PrintReportInterface {

    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Another one PrintReport!");
    }
}
