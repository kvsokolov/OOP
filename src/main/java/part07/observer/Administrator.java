package part07.observer;

public class Administrator implements Observer {
    private String name;
    private double salary;
    private Occupation profession;

    public Administrator(String name) {
        this.name = name;
        salary = 15000;
        profession = Occupation.administrativeWorker;
    }

    @Override
    public void recieveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && profession == vacancy.getOccupation()) {
            System.out.printf("Администратор: %s >>> Мне нужна эта работа! [%s - %f - %s]\n", name, vacancy.getCompanyName(), vacancy.getSalary(), vacancy.getOccupation());
            this.salary = vacancy.getSalary();
        } else if (profession != vacancy.getOccupation())
            System.out.printf("Администратор: Это не моя профессия, я администратор! [%s - %f - %s]\n", vacancy.getCompanyName(), salary, vacancy.getOccupation());
        else
            System.out.printf("Администратор: %s >>> Я найду работу получше! [%s - %f - %s]\n", name, vacancy.getCompanyName(), salary, vacancy.getOccupation());
    }
}
