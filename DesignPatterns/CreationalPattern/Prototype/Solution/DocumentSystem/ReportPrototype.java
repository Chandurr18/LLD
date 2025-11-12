package CreationalPattern.Prototype.Solution.DocumentSystem;

/**
 * Prototype interface declaring clone method.
 */
public interface ReportPrototype extends Cloneable {
    ReportPrototype clone();
    void print();
}
