package recommendation;

import patron.Patron;

import java.util.*;

public class RecommendationService {
    public List<String> recommendBooks(Patron patron) {
        // Placeholder: Recommend based on history length
        if (patron.getBorrowingHistory().isEmpty()) {
            return List.of("To Kill a Mockingbird", "Pride and Prejudice");
        } else {
            return List.of("Brave New World", "Fahrenheit 451");
        }
    }
}