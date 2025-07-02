package lending;

import patron.Patron;

import java.util.*;

public class ReservationService {
    private Map<String, List<Patron>> reservations = new HashMap<>();

    public void reserveBook(Patron patron, String isbn) {
        reservations.computeIfAbsent(isbn, k -> new ArrayList<>()).add(patron);
    }

    public List<Patron> getReservationList(String isbn) {
        return reservations.getOrDefault(isbn, Collections.emptyList());
    }
}