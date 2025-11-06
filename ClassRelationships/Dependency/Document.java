package ClassRelationships.Dependency;

/**
 * Dependency (USES-A):
 * Document holds content that can be printed.
 * Printer does not store Document; it BORROWS it temporarily.
 */
public class Document {

    private String content;

    public Document(String content) {
        this.content = content;
        System.out.println("Document created with content: " + content);
    }

    public String getContent() {
        return content;
    }

    public void formatBeforePrint() {
        System.out.println("Formatting document content...");
    }
}
