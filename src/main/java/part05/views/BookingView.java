package part05.views;

import part05.models.Table;
import part05.presenters.View;
import part05.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    /**
     * Отобразить список сотликов
     * @param tables список столиков
     */
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Отобразить результат бронирования
     * @param reservationNo номер бронирования
     */
    @Override
    public void showReservationStatus(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Ваш столик был успешно забронирован. Номер брони: %d\n", reservationNo);
        else if (reservationNo == -1)
            System.out.println("Ошибка бронирования столика.");
        else if (reservationNo == 0) {
            System.out.println("Ваша бронь анулирована.");
        }
    }

    /**
     * Устновить наблюдателя
     * @param observer наблюдатель (презентер)
     */
    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования),
     * бронирование столика
     * @param date дата бронирования
     * @param name имя клиента
     * @param no номер столика
     */
    public void reservationTable(Date date, String name, int no) {
        observer.onReservationTable(date, name, no);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        //TODO: Обратиться к наблюдателю, указать на процедуру изменения бронирования столика
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }
    public void changeReservationTable(int oldReservation) {
        //TODO: Обратиться к наблюдателю, указать на процедуру изменения бронирования столика
        observer.onChangeReservationTable(oldReservation);
    }

}
