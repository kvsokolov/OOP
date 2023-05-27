package part07.observer;

public class BookKeeper implements Observer {
    private String name;
    private double salary;
    private Occupation profession;

    public BookKeeper(String name) {
        this.name = name;
        salary = 30000;
        profession = Occupation.financial;
    }

    @Override
    public void recieveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && profession == vacancy.getOccupation()) {
            System.out.printf("Бухгалтер: %s >>> Мне нужна эта работа! [%s - %f - %s]\n", name, vacancy.getCompanyName(), vacancy.getSalary(), vacancy.getOccupation());
            this.salary = vacancy.getSalary();
        } else if (profession != vacancy.getOccupation())
            System.out.printf("Бухгалтер: Это не моя профессия, я финансист! [%s - %f - %s]\n", vacancy.getCompanyName(), salary, vacancy.getOccupation());
        else
            System.out.printf("Бухгалтер: %s >>> Я найду работу получше! [%s - %f - %s]\n", name, vacancy.getCompanyName(), salary, vacancy.getOccupation());
    }
}
