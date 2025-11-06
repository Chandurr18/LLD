package ClassRelationships.Association.Bi_Directional;

import java.util.ArrayList;

public class Author {
    public String authorName;
    ArrayList<Book> books = new ArrayList<>();

    public Author(String authorName){
        this.authorName = authorName;
    }

    public void addBook(Book book){
        books.add(book);
        book.setAuthor(this);
    }

}
