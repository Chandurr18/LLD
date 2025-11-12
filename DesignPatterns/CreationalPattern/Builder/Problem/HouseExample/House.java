package HouseExample;

/**
 * ❌ Problem:
 * Too many constructor parameters lead to telescoping constructors.
 * This causes confusion, low readability, and high maintenance cost.
 */
public class House {
    private final boolean hasGarage;
    private final boolean hasGarden;
    private final int floors;
    private final String roofType;
    private final boolean hasSwimmingPool;
    private final boolean hasBasement;

    // Telescoping constructor (anti-pattern)
    public House(boolean hasGarage, boolean hasGarden, int floors,
                 String roofType, boolean hasSwimmingPool, boolean hasBasement) {
        this.hasGarage = hasGarage;
        this.hasGarden = hasGarden;
        this.floors = floors;
        this.roofType = roofType;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasBasement = hasBasement;
    }

    @Override
    public String toString() {
        return "House{" +
                "hasGarage=" + hasGarage +
                ", hasGarden=" + hasGarden +
                ", floors=" + floors +
                ", roofType='" + roofType + '\'' +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasBasement=" + hasBasement +
                '}';
    }
}
