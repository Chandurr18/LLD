// Association (knows-a) is a long-term relationship where one object simply knows or references another, with both able to exist independently.
// Association → knows
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
