package ClassRelationships.Aggregation;

/**
 * Aggregation:
 * Professor can exist independently of Department.
 */
public class Professor {

    private String name;

    public Professor(String name) {
        this.name = name;
        System.out.println("Professor created: " + name);
    }

    public String getName() {
        return name;
    }

    public void teach() {
        System.out.println(name + " is teaching...");
    }
}
