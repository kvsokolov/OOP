package part07.observer;

import java.util.Random;

public class Vacancy {

    Random rndSal = new Random();
    private Occupation occupation;
    private double salary;
    private String companyName;

//    public Vacancy(Occupation occupation, double salary) {
//        this.occupation = occupation;
//        this.salary = salary;
//    }

    public Vacancy(String companyName) {
        rndVacancy(companyName);
    }

    public void rndVacancy(String companyName) {
        this.companyName = companyName;
        occupation = Occupation.randomOccupation();

        switch (this.occupation) {
            case developerSenior:
                this.salary = rndSal.nextDouble(75000, 120000);
                break;
            case developerJunior:
                this.salary = rndSal.nextDouble(3000, 15000);
                break;
            case administrativeWorker:
                this.salary = rndSal.nextDouble(10000, 20000);
                break;
            case worker:
                this.salary = rndSal.nextDouble(5000, 25000);
                break;
            case lawyer:
                this.salary = rndSal.nextDouble(40000, 90000);
                break;
            case financial:
                this.salary = rndSal.nextDouble(25000, 37000);
                break;
            default:
                this.salary = 0;
                break;

        }
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public double getSalary() {
        return salary;
    }

    public String getCompanyName() {
        return companyName;
    }
}
