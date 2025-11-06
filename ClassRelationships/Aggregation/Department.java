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
