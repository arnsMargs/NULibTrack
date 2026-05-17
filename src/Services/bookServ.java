package Services;

import LibTrackModel.modelBook;
import java.time.LocalDate;
import java.util.*;

public class bookServ {
    
    public static void borrowBook(int id){
        for(modelBook book : dB.books){
            if(book.getId() == id){
                book.setAvailable(false);

                LocalDate due = LocalDate.now().plusDays(7);
                book.setDueDate(due.toString());
                book.setBorrowedDate(LocalDate.now().toString());
                break;
            }
        }
    }

    public static void returnBook(int id){
        for(modelBook book : dB.books){
            if(book.getId() == id){
                book.setAvailable(true);
                book.setDueDate(null);
                book.setBorrowedDate(null);
                break;
            }
        }
    }

    public static List<String> getWarnings(){

        List<String> warnings = new ArrayList<>();

        for(modelBook book : dB.books){

            if(book.getDueDate() != null){
                LocalDate due = LocalDate.parse(book.getDueDate());

                if(LocalDate.now().isAfter(due)){
                    warnings.add("OVERDUE: " + book.getTitle() + " (Due: " + book.getDueDate()+ ")");
                }else if (LocalDate.now().plusDays(2).isAfter(due)){
                    warnings.add("DUE SOON: " + book.getTitle()+ " (Due: " + book.getDueDate()+ ")");
                }
                }

            }
            return warnings;
        }
    }
    

