package LibTrackModel;

public class modelBook {
    int id;
    String title;
    String status;
    String author;
    String categores;
    int quantity;
    private String dueDate;
    private String borrowedDate;


    public modelBook(int id, String title, String author, String categories, int quantity){
        this.id = id;
        this.title = title;
        this.author = author;
        this.categores = categories;
        this.quantity = quantity;
    }
    
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getCategories(){return categores;}
    public int getQuantity(){return quantity;}
    public boolean isAvailable(){return quantity > 0;}
    public void setAvailable(boolean available){
        this.setAvailable(available);
    }
    
        public String getBorrowedDate() {
            return borrowedDate;
        }

        public void setBorrowedDate(String borrowedDate) {
            this.borrowedDate = borrowedDate;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }
    }


   


