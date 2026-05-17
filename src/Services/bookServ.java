package Services;

import LibTrackModel.modelBook;

public class bookServ {
    
    public static void borrowBook(int id){
        for(modelBook book : dB.books){
            if(book.getId() == id){
                book.setAvailable(false);
                break;
            }
        }
    }

    public static void returnBook(int id){
        for(modelBook book : dB.books){
            if(book.getId() == id){
                book.setAvailable(true);
                break;
            }
        }
    }
    
}
