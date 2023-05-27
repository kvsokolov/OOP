package part07.observer;

public class Program {
    public static void main(String[] args) {

        /**
         * TODO: Доработать приложение, поработать с шаблоном проектирования Observer
         * Добавить  новый тип соискателя.
         * Добавить новую сущность "Вакансия", компания должна рассылать агенствам вакансии.
         * @params args
         */
        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);

        Master ivanov = new Master("Ivanov");
        Master sidorov = new Master("Sidorov");
        Student petrov = new Student("Petrov");
        Worker vasin = new Worker("Vasin");
        Administrator voronina = new Administrator("Воронина");
        BookKeeper prokhorova = new BookKeeper("Прохорова");
        Lawyer karapetyan = new Lawyer("Карапетян");

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(vasin);
        jobAgency.registerObserver(voronina);
        jobAgency.registerObserver(prokhorova);
        jobAgency.registerObserver(karapetyan);


        for (int i = 0; i < 10; i++) {
            geekBrains.needEmployee(new Vacancy(geekBrains.getNameCompany()));
            System.out.println();
            google.needEmployee(new Vacancy(google.getNameCompany()));
            System.out.println();
            yandex.needEmployee(new Vacancy(yandex.getNameCompany()));
            System.out.println();
        }

    }
}
