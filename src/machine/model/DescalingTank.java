package machine.model;

public class DescalingTank {

    private static final double MAX_LEVEL = 1.0;
    private static final double MIN_REQUIRED_LEVEL = 0.4;

    private double currentLevel;
    private FluidSensor sensor;

    public DescalingTank() {
        this.currentLevel = 0.0; // يبدأ فارغ
        this.sensor = new FluidSensor(this);
    }

    public void fillTank() {
        this.currentLevel = MAX_LEVEL;
        System.out.println("[TANK] Tank refilled to 100%.");
    }

    public boolean isFluidLevelSufficient() {
        double level = sensor.readLevel();
        System.out.printf("[TANK] Current fluid level: %.2f%n", level);
        return level >= MIN_REQUIRED_LEVEL;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    public boolean consume(double amount) {
        if (currentLevel >= amount) {
            currentLevel -= amount;
            System.out.printf("[TANK] Consumed %.2f units. Remaining: %.2f%n", amount, currentLevel);
            return true;
        } else {
            System.out.println("[TANK] Not enough fluid to consume.");
            return false;
        }
    }
}
