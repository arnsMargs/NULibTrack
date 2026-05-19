package Services;

import java.util.*;
import LibTrackModel.*;

public class dB {

    public static List<modelU> users = new ArrayList<>();
    public static List<modelBook> books = new ArrayList<>();

    static {

        users.add(new modelLib("lib@nu.com", "1234", "Librarian"));
        users.add(new modelPat("pat@nu.com", "1234", "Patron"));

        books.add(new modelBook(1, "Clean Code", "Robert Martin", "Programming", 3));
        books.add(new modelBook(2, "Java Basics", "Oracle", "Programming", 5));
        books.add(new modelBook(3, "Design Patterns", "GoF", "Software", 2));
    }
}
