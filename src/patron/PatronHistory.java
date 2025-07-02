package patron;

import java.util.*;

public class PatronHistory {
    private Map<String, List<String>> history = new HashMap<>();

    public void addHistory(String patronId, String bookIsbn) {
        history.computeIfAbsent(patronId, k -> new ArrayList<>()).add(bookIsbn);
    }

    public List<String> getHistory(String patronId) {
        return history.getOrDefault(patronId, Collections.emptyList());
    }
}