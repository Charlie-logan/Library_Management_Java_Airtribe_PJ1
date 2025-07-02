package lending;

import book.Book;
import book.BookInventory;
import patron.Patron;

import java.util.logging.Logger;

public class LendingService {
    private BookInventory inventory;
    private static final Logger logger = Logger.getLogger(LendingService.class.getName());

    public LendingService(BookInventory inventory) {
        this.inventory = inventory;
    }

    public void checkoutBook(Patron patron, String isbn) {
        Book book = inventory.getBook(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            patron.addToBorrowingHistory(isbn);
            logger.info(patron.getName() + " checked out " + isbn);
        } else {
            logger.warning("Checkout failed for " + isbn + " by " + patron.getName());
        }
    }

    public void returnBook(Patron patron, String isbn) {
        Book book = inventory.getBook(isbn);
        if (book != null) {
            book.setAvailable(true);
            logger.info(patron.getName() + " returned " + isbn);
        }
    }

    public void processReservations(Patron patron) {
        for (String isbn : patron.getReservations()) {
            Book book = inventory.getBook(isbn);
            if (book != null && book.isAvailable()) {
                checkoutBook(patron, isbn);
            }
        }
    }
}