package part07.observer;

public class Master implements Observer {
    private String name;
    private double salary;
    private Occupation profession;

    public Master(String name) {
        this.name = name;
        salary = 80000;
        profession = Occupation.developerSenior;
    }

    @Override
    public void recieveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && profession == vacancy.getOccupation()) {
            System.out.printf("Мастер: %s >>> Мне нужна эта работа! [%s - %f - %s]\n", name, vacancy.getCompanyName(), vacancy.getSalary(), vacancy.getOccupation());
            this.salary = vacancy.getSalary();
        } else if (profession != vacancy.getOccupation())
            System.out.printf("Мастер: Это не моя профессия, я старший разработчик! [%s - %f - %s]\n", vacancy.getCompanyName(), salary, vacancy.getOccupation());
        else
            System.out.printf("Мастер: %s >>> Я найду работу получше! [%s - %f - %s]\n", name, vacancy.getCompanyName(), salary, vacancy.getOccupation());
    }
}
