//Printer depends on a Document to print

package ClassRelationships.Dependency;


public class Document {
    private String content;

    public Document(String content){
        this.content = content;
    }
    
    public String getContent(){
        return content;
    }
    
}