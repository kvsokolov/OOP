package part05.models;

import part05.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                tables.add(new Table());
            }
        }
        return tables;
    }

    public int reservationTable(Date orderDate, String name, int no) {
        for (Table table : tables) {
            if (table.getNo() == no) {
                Reservation reservation = new Reservation(orderDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика!");
    }

    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    table.getReservations().remove(reservation);
                    break;
                }
            }
        }
        return reservationTable(reservationDate, name, tableNo);
    }

    public int changeReservationTable(int oldReservation) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    table.getReservations().remove(reservation);
                    break;
                }
            }
        }
        return 0;
    }
}
