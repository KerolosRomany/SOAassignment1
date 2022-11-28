package assignment1;

public class Book {
    private String ID;
    private String Author;
    private String Title;
    private String Genre;
    private double Price;
    private String Publish_Date;
    private String Description;
    public Book(String ID,String Author,String Title, String Genre,double Price,String Publish_Date,String Description){
        this.ID=ID;
        this.Author = Author;
        this.Title = Title;
        this.Genre = Genre;
        this.Price = Price;
        this.Publish_Date = Publish_Date;
        this.Description = Description;
    }
    @Override
    public String toString() {
        return "ID: " + ID + ", \nAuthor: " + Author + ", \nTitle: " + Title +", \nGenre: "+Genre
        +", \nPrice: "+Price+", \nPublish Date: "+Publish_Date+", \nDescription: "+Description;
    }

}
