// Solution 1 : Separate Builder class and Director


package Solution.Solution1;

// ==========================
// 1. Product Class
// ==========================
class House {
    private int doors;
    private int windows;
    private boolean hasGarage;
    private boolean hasGarden;

    // Setters
    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public void setGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public void setGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    @Override
    public String toString() {
        return "House [doors=" + doors +
               ", windows=" + windows +
               ", garage=" + hasGarage +
               ", garden=" + hasGarden + "]";
    }
}

// ==========================
// 2️⃣ Builder Interface
// ==========================
interface HouseBuilder {
    HouseBuilder setDoors(int doors);
    HouseBuilder setWindows(int windows);
    HouseBuilder setGarage(boolean hasGarage);
    HouseBuilder setGarden(boolean hasGarden);
    House build();
}

// ==========================
// 3️⃣ Concrete Builder
// ==========================
class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    @Override
    public HouseBuilder setDoors(int doors) {
        house.setDoors(doors);
        return this; // 🔁 fluent return
    }

    @Override
    public HouseBuilder setWindows(int windows) {
        house.setWindows(windows);
        return this;
    }

    @Override
    public HouseBuilder setGarage(boolean hasGarage) {
        house.setGarage(hasGarage);
        return this;
    }

    @Override
    public HouseBuilder setGarden(boolean hasGarden) {
        house.setGarden(hasGarden);
        return this;
    }

    @Override
    public House build() {
        return house;
    }
}

// ==========================
// 4️⃣ Director (Optional)
// ==========================
class HouseDirector {
    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    // Director defines a standard sequence of steps
    public House constructLuxuryHouse() {
        return builder
                .setDoors(6)
                .setWindows(10)
                .setGarage(true)
                .setGarden(true)
                .build();
    }

    public House constructSimpleHouse() {
        return builder
                .setDoors(2)
                .setWindows(4)
                .setGarage(false)
                .setGarden(false)
                .build();
    }
}

