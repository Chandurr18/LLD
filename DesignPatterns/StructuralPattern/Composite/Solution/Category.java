package StructuralPattern.Composite.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class representing a category that can contain Products and
 * sub-categories.
 * It implements CatalogComponent and delegates showDetails() to its children
 * recursively.
 */
public class Category implements CatalogComponent {
    private final String name;
    private final List<CatalogComponent> children = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void add(CatalogComponent component) {
        children.add(component);
    }

    public void remove(CatalogComponent component) {
        children.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Category: " + name);
        for (CatalogComponent c : children) {
            c.showDetails();
        }
    }
}
