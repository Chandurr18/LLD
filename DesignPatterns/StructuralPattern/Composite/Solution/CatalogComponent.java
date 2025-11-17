package StructuralPattern.Composite.Solution;

/**
 * Component interface for Composite pattern.
 * Defines a common operation that both leaf (Product) and composite (Category)
 * implement.
 * This enables clients to treat individual objects and groups uniformly.
 */
public interface CatalogComponent {
    void showDetails();
}
