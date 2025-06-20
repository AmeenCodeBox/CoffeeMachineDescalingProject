package machine.view;

public class Display {

    public void showMessage(String message) {
        System.out.println("[DISPLAY] " + message);
    }

    public void showError(String message) {
        System.err.println("[ERROR] " + message);
    }

    public void showPhase(String phase) {
        System.out.println("[DESCALING] " + phase);
    }

    public void showCompletion() {
        System.out.println("[DISPLAY] Descaling completed successfully. System will now reset.\n");
    }
}
