package part07.observer;

public class Student implements Observer {

    private String name;
    private double salary;
    private Occupation profession;

    public Student(String name) {
        this.name = name;
        salary = 5000;
        profession = Occupation.developerJunior;
    }

    @Override
    public void recieveOffer(Vacancy vacancy) {
        if (this.salary < vacancy.getSalary() && profession == vacancy.getOccupation()) {
            System.out.printf("Студент: %s >>> Мне нужна эта работа! [%s - %f - %s]\n", name, vacancy.getCompanyName(), vacancy.getSalary(), vacancy.getOccupation());
            this.salary = vacancy.getSalary();
        } else if (profession != vacancy.getOccupation())
            System.out.printf("Студент: Это не моя профессия, я младший разработчик! [%s - %f - %s]\n", vacancy.getCompanyName(), salary, vacancy.getOccupation());
        else
            System.out.printf("Студент: %s >>> Я найду работу получше! [%s - %f - %s]\n", name, vacancy.getCompanyName(), salary, vacancy.getOccupation());
    }
}
