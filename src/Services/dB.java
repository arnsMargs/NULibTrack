package Services;

import java.util.*;

import LibTrackModel.modelBook;
import LibTrackModel.modelU;

public class dB {
    
    public static List<modelU> users = new ArrayList<>();
    public static List<modelBook> books = new ArrayList<>();

    static{
        books.add(new modelBook(1,"Modern Java in Action", "Raoul-Gabriel Urma", "Programming", 5));
        books.add(new modelBook(2,"Clean Code", "Robert C. Martin", "Programming", 3));
        books.add(new modelBook(3,"The Pragmatic Programmer", "Andrew Hunt", "Programming", 4));
        books.add(new modelBook(4,"Design Patterns", "Erich Gamma", "Programming", 2));
    }
}
