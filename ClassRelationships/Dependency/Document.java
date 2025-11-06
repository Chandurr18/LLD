// Dependency (uses-a) is a short-lived “uses” relationship where one object temporarily depends on another to perform a task, without storing it as a field.
// Dependency → borrows

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