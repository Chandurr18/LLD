package CreationalPattern.Builder.Solution.HouseExample.Solution2;

/**
 * ✅ Solution 2:
 * Nested Static Builder (fluent interface style)
 * More compact and elegant. Inspired by Lombok @Builder.
 */
public class House {
    private final boolean hasGarage;
    private final boolean hasGarden;
    private final int floors;
    private final String roofType;
    private final boolean hasSwimmingPool;
    private final boolean hasBasement;

    private House(Builder builder) {
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
        this.floors = builder.floors;
        this.roofType = builder.roofType;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasBasement = builder.hasBasement;
    }

    public static class Builder {
        private boolean hasGarage;
        private boolean hasGarden;
        private int floors;
        private String roofType;
        private boolean hasSwimmingPool;
        private boolean hasBasement;

        public Builder garage(boolean val) { this.hasGarage = val; return this; }
        public Builder garden(boolean val) { this.hasGarden = val; return this; }
        public Builder floors(int val) { this.floors = val; return this; }
        public Builder roof(String val) { this.roofType = val; return this; }
        public Builder pool(boolean val) { this.hasSwimmingPool = val; return this; }
        public Builder basement(boolean val) { this.hasBasement = val; return this; }

        public House build() { return new House(this); }
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
