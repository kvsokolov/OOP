package part06.dip;

public class Program {

    //TODO: (2 задание ) Доработать самостоятельно
    public static void main(String[] args) {
        Report report = new Report();
        report.calculate();
        report.output();
        report.setPrintReport(new PrintReport());
        report.output();
        report.setPrintReport(new SaveToTXT());
        report.output();
        report.setPrintReport(new PrintReport3());
        report.output();
    }
}
