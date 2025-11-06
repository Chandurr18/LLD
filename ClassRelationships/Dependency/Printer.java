package ClassRelationships.Dependency;

/**
 * Dependency:
 * Printer depends on Document temporarily to perform printing.
 * It does NOT own or store the Document.
 */
public class Printer {

    public void printDocument(Document document) {
        document.formatBeforePrint();
        System.out.println("Printing Document: " + document.getContent());
    }
}
