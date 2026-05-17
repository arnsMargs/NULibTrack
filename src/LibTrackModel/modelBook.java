package LibTrackModel;

public class modelBook {
    int id;
    String title;
    String status;
    String author;
    String categores;
    int quantity;

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
        if(available){
            quantity++;
        } else {
            quantity--;
        }
    }

    
}

