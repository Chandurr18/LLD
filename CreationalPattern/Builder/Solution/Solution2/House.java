//Solution 2 : Inner Static Builder class (Telescopic Constructor Alternative)

package CreationalPattern.Builder.Solution.Solution2;

public class House {
    // ====== Product Fields ======
    private final int doors;
    private final int windows;
    private final boolean hasGarage;
    private final boolean hasGarden;

    // Private constructor — only Builder can call this
    private House(Builder builder) {
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
    }

    // ====== Static Inner Builder Class ======
    public static class Builder {
        private int doors;
        private int windows;
        private boolean hasGarage;
        private boolean hasGarden;

        // Fluent methods — return "this"
        public Builder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder windows(int windows) {
            this.windows = windows;
            return this;
        }

        public Builder hasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public Builder hasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        // Final step — build
        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House [doors=" + doors +
                ", windows=" + windows +
                ", garage=" + hasGarage +
                ", garden=" + hasGarden + "]";
    }
}