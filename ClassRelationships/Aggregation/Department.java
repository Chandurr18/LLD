// Aggregation (has-a, whole–part with independent lifecycle) is a specialized association forming a weak whole-part relationship where the part belongs to the whole but can still exist independently if the whole is destroyed.
// Aggregation → has (weak ownership)

package ClassRelationships.Aggregation;

import java.util.List;

public class Department {
    private String departmentName;
    private List<Proffesor> proffesors;

    public Department(String departmentName, List<Proffesor> proffesors){
        this.departmentName = departmentName;
        this.proffesors = proffesors;
    }
}
