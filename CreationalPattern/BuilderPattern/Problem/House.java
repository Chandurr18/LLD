package Problem;
public class House {
    private int doors;
    private int windows;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    public House(int doors, int windows, boolean hasGarage, boolean hasSwimmingPool, boolean hasGarden) {
        this.doors = doors;
        this.windows = windows;
        this.hasGarage = hasGarage;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasGarden = hasGarden;
    }

    @Override
    public String toString() {
        return "House [doors=" + doors +
                ", windows=" + windows +
                ", garage=" + hasGarage +
                ", swimmingPool=" + hasSwimmingPool +
                ", garden=" + hasGarden + "]";
    }
}
