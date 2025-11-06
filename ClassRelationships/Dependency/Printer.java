package ClassRelationships.Dependency;

public class Printer {
    public void printDocument(Document document){
        System.out.println("Printing Doument : " + document.getContent());
    }
}
