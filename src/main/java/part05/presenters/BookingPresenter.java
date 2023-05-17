package part05.presenters;

import part05.models.Reservation;
import part05.models.Table;
import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Загрузить список всех столиков
     */
    public void loadTables() {
        if (tables == null) {
            tables = model.loadTables();
        }
    }

    /**
     * Отобразить список столиков
     */
    public void updateView() {
        this.view.showTables(tables);
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    private void updateReservationStatusView(int reservationNo) {
        view.showReservationStatus(reservationNo);
    }

    /**
     * Получили уведомление о попытке бронирования столика
     * @param orderDate дата бронирования
     * @param name имя клиента
     * @param no номер столика
     */
    @Override
    public void onReservationTable(Date orderDate, String name, int no) {
        int reservationId = model.reservationTable(orderDate, name, no);
        updateReservationStatusView(reservationId);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationId = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateReservationStatusView(reservationId);
    }
    public void onChangeReservationTable(int oldReservation) {
        int reservationId = model.changeReservationTable(oldReservation);
        updateReservationStatusView(reservationId);
    }
}
