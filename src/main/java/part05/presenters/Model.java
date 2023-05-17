package part05.presenters;

import part05.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    /**
     * Получение всех столиков в ресторане
     * @return
     */
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param orderDate дата бронирования
     * @param name имя клиента
     * @param no номер столика
     * @return номер брони
     */
    int reservationTable(Date orderDate, String name, int no);

    int changeReservationTable(int oldReservationNo, Date orderDate, int no, String name);
    int changeReservationTable(int oldReservationNo);

}
