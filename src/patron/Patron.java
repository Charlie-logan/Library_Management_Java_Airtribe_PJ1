package patron;

import notification.Observer;

import java.util.*;

public class Patron implements Observer {
    private String id;
    private String name;
    private List<String> borrowingHistory;
    private List<String> reservations;

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowingHistory = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void addToBorrowingHistory(String isbn) {
        borrowingHistory.add(isbn);
    }

    public List<String> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void reserveBook(String isbn) {
        reservations.add(isbn);
    }

    public List<String> getReservations() {
        return reservations;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + ": " + message);
    }
}