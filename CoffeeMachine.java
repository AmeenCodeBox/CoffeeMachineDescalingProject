package machine.model;

import machine.view.Display;

public class CoffeeMachine {

    private DescalingTank tank;
    private Display display;
    private int coffeeCount;
    private final int DESCALING_THRESHOLD = 5;
    private boolean locked;
    private LogManager logger;


    public CoffeeMachine(DescalingTank tank, Display display, LogManager logger) {
        this.tank = tank;
        this.display = display;
        this.logger = logger;
        this.coffeeCount = 0;
        this.locked = false;
    }

    public void makeCoffee() {
        if (locked) {
            display.showError("Cannot make coffee. Descaling required.");
            return;
        }

        if (!tank.consume(0.15)) {
            display.showError("Not enough water to make coffee.");
            return;
        }

        coffeeCount++;
        logger.log("Coffee made (cup " + coffeeCount + ")");
        display.showMessage("Coffee made! Total: " + coffeeCount);

        if (coffeeCount >= DESCALING_THRESHOLD) {
            locked = true;
            display.showError("Descaling required! System is locked.");
            logger.log("System locked due to scale buildup.");
        }
    }


    public boolean needsDescaling() {
        return locked;
    }

    public void resetAfterDescaling() {
        coffeeCount = 0;
        locked = false;
    }
}
