package ClassRelationships.Aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregation (HAS-A):
 * Department aggregates Professors.
 * Professors can exist without the Department.
 */
public class Department {

    private String departmentName;
    private List<Professor> professors;

    public Department(String departmentName, List<Professor> professors) {
        this.departmentName = departmentName;
        // Defensive copy
        this.professors = new ArrayList<>(professors);
        System.out.println("Department created: " + departmentName);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
        System.out.println(professor.getName() + " added to " + departmentName);
    }

    public void listProfessors() {
        System.out.println("Professors in " + departmentName + ":");
        for (Professor p : professors) {
            System.out.println("- " + p.getName());
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Professor> getProfessors() {
        return professors;
    }
}
