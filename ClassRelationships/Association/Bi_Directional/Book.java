package ClassRelationships.Association.Bi_Directional;

/**
 * Bi-Directional Association:
 * Book knows its Author AND Author knows its Books.
 */
public class Book {

    private String title;
    private Author author;

    public Book(String title) {
        this.title = title;
        System.out.println("Book created: " + title);
    }

    public void setAuthor(Author author) {
        this.author = author;
        System.out.println("Author \"" + author.getAuthorName() + "\" assigned to book: " + title);
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}
