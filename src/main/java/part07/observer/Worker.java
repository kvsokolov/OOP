package part07.observer;

public class Worker implements Observer {

    private String name;
    private double salary;
    private Occupation profession;

    public Worker(String name) {
        this.name = name;
        salary = 20000;
        profession = Occupation.worker;
    }

    @Override
    public void recieveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && profession == vacancy.getOccupation()) {
            System.out.printf("Рабочий: %s >>> Мне нужна эта работа! [%s - %f - %s]\n", name, vacancy.getCompanyName(), vacancy.getSalary(), vacancy.getOccupation());
            this.salary = vacancy.getSalary();
        } else if (profession != vacancy.getOccupation())
            System.out.printf("Рабочий: Это не моя профессия, я рабочий! [%s - %f - %s]\n", vacancy.getCompanyName(), salary, vacancy.getOccupation());
        else
            System.out.printf("Рабочий: %s >>> Я найду работу получше! [%s - %f - %s]\n", name, vacancy.getCompanyName(), salary, vacancy.getOccupation());
    }

}
