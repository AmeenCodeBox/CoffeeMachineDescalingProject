package machine.model;

import machine.view.Display;

public class DescalingPhaseManager {

    public void runAllPhases(Display display) {
        runPhase("Phase 1: Rinse", 2000, display);
        runPhase("Phase 2: descaling", 6000, display);
        runPhase("Phase 3: Rinse again", 2000, display);

        display.showMessage("All phases completed.\n");
    }

    private void runPhase(String phaseName, int durationMillis, Display display) {
        display.showPhase(phaseName + " started...");
        try {
            Thread.sleep(durationMillis);
        } catch (InterruptedException e) {
            display.showError("Phase interrupted.");
        }
        display.showPhase(phaseName + " finished.\n");
    }
}
