package machine.controller;

import machine.model.CoffeeMachine;
import machine.model.DescalingTank;
import machine.model.DescalingPhaseManager;
import machine.view.Display;
import machine.model.LogManager;

import java.util.Scanner;

public class MainController {

    private DescalingTank tank;
    private DescalingPhaseManager phaseManager;
    private CoffeeMachine coffeeMachine;
    private Display display;
    private LogManager logger;


    public MainController() {
        this.display = new Display();
        this.tank = new DescalingTank();
        this.phaseManager = new DescalingPhaseManager();
        this.logger = new LogManager();
        this.coffeeMachine = new CoffeeMachine(tank, display, logger);
    }

    public void start() {
        display.showMessage("Welcome to the Coffee Machine Descaling Program!");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Choose an option: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    tank.fillTank();
                    logger.log("Tank filled");
                }
                case 2 -> coffeeMachine.makeCoffee();
                case 3 -> runDescaling();
                case 4 -> logger.printLog();
                case 0 -> display.showMessage("Exiting the program. Goodbye!");
                default -> display.showError("Invalid choice.");
            }


        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("\n====== MENU ======");
        System.out.println("1. Fill Tank");
        System.out.println("2. Make Coffee");
        System.out.println("3. Start Descaling");
        System.out.println("4. View Log");
        System.out.println("0. Exit");
        System.out.println("==================");
    }


    private void runDescaling() {
        if (!coffeeMachine.needsDescaling()) {
            display.showMessage("Descaling not required yet.");
            return;
        }

        if (!checkTank()) {
            display.showError("Not enough fluid to descale. Please refill the tank.");
            return;
        }

        display.showMessage("Running descaling process...");
        logger.log("Descaling started");

        phaseManager.runAllPhases(display);

        logger.log("Descaling completed");
        coffeeMachine.resetAfterDescaling();
        resetSystem();
    }

    private boolean checkTank() {
        display.showMessage("Checking fluid level...");
        boolean sufficient = tank.isFluidLevelSufficient();
        if (sufficient) {
            display.showMessage("Fluid is sufficient.\n");
        }
        return sufficient;
    }

    private void resetSystem() {
        display.showCompletion();
    }
}
