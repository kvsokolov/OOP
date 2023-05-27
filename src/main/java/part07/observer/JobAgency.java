package part07.observer;

import java.util.ArrayList;
import java.util.List;

public class JobAgency implements Publisher {

    List<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Реализация рассылки сообщений
     * @param nameCompany Имя компании
     * @param salary Зарплата
     */
    @Override
    public void sendOffer(Vacancy vacancy) {
        for (Observer observer : observers) {
            observer.recieveOffer(vacancy);
        }
    }
}
