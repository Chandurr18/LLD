package ClassRelationships.Association.Bi_Directional;

public class Book {
    public String title;
    public Author author;
    
    public Book(String title){
        this.title = title;
    }

    public void setAuthor(Author author){
        this.author = author;
    }
}
