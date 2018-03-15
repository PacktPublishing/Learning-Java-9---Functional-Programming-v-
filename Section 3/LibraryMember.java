package Product3.FunctionalProgramming;

import java.util.HashSet;
import java.util.Set;

public class LibraryMember {
    private Set<String> booksOnLoan = new HashSet<>();

    public void addBook(String book) {
        booksOnLoan.add(book);
    }

    public Set<String> getBooksOnLoan() {
        return booksOnLoan;
    }
}
