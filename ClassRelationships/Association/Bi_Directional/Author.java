package ClassRelationships.Association.Bi_Directional;

import java.util.ArrayList;
import java.util.List;

/**
 * Bi-Directional Association:
 * Author knows its Books AND each Book knows its Author.
 * Both can exist independently.
 */
public class Author {

    private String authorName;
    private List<Book> books = new ArrayList<>();

    public Author(String authorName) {
        this.authorName = authorName;
        System.out.println("Author created: " + authorName);
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
        System.out.println("Book \"" + book.getTitle() + "\" added to author: " + authorName);
    }

    public String getAuthorName() {
        return authorName;
    }

    public List<Book> getBooks() {
        return books;
    }
}
