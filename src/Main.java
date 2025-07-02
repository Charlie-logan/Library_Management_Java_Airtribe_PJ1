import book.*;
import patron.*;
import lending.*;
import config.LoggerConfig;
import notification.*;
import recommendation.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LoggerConfig.configure();

        BookInventory inventory = new BookInventory();
        LendingService lendingService = new LendingService(inventory);
        RecommendationService recommendationService = new RecommendationService();

        initializeBooks(inventory);
        Patron patron = initializePatron();
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(patron);

        performLendingActions(lendingService, patron);
        performReservationAndNotification(lendingService, notificationService, patron);
        displayInventory(inventory);
        displayRecommendations(recommendationService, patron);
        displayBorrowingHistory(patron);
        displayReservationHistory(patron);
    }

    private static void initializeBooks(BookInventory inventory) {
        Book book1 = BookFactory.createBook("1984", "George Orwell", "123", 1949);
        Book book2 = BookFactory.createBook("Animal Farm", "George Orwell", "124", 1945);
        inventory.addBook(book1);
        inventory.addBook(book2);
    }

    private static Patron initializePatron() {
        return new Patron("1", "Alice");
    }

    private static void performLendingActions(LendingService lendingService, Patron patron) {
        lendingService.checkoutBook(patron, "123");
        lendingService.returnBook(patron, "123");
        lendingService.checkoutBook(patron, "999");
    }

    private static void performReservationAndNotification(LendingService lendingService, NotificationService notificationService, Patron patron) {
        patron.reserveBook("124");
        lendingService.processReservations(patron);
        notificationService.notifyObservers("Book 'Animal Farm' is now available!");
    }

    private static void displayInventory(BookInventory inventory) {
        for (Book b : inventory.getAllBooks()) {
            System.out.println(b + " - Available: " + b.isAvailable());
        }
    }

    private static void displayRecommendations(RecommendationService recommendationService, Patron patron) {
        recommendationService.recommendBooks(patron).forEach(System.out::println);
    }

    private static void displayBorrowingHistory(Patron patron) {
        System.out.println("Borrowing History:");
        patron.getBorrowingHistory().forEach(System.out::println);
    }

    private static void displayReservationHistory(Patron patron) {
        System.out.println("Reservation History:");
        patron.getReservations().forEach(System.out::println);
    }
}