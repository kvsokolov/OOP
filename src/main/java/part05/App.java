package part05;

import part05.models.TableModel;
import part05.presenters.BookingPresenter;
import part05.views.BookingView;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);

        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), "Константин", 5);

        bookingView.changeReservationTable(1001, new Date(), 1, "Константин");
        bookingView.changeReservationTable(1002);
        bookingView.changeReservationTable(1001, new Date(), 1, "Константин");
        bookingView.changeReservationTable(1064, new Date(), 1, "Константин");

    }
}