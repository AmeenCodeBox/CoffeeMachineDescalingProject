package machine.model;

public class FluidSensor {

    private DescalingTank tank;

    public FluidSensor(DescalingTank tank) {
        this.tank = tank;
    }

    public double readLevel() {
        return tank.getCurrentLevel();
    }
}
