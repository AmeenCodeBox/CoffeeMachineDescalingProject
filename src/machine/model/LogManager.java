package machine.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogManager {

    private List<String> logs = new ArrayList<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void log(String action) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        logs.add(timestamp + " - " + action);
    }

    public void printLog() {
        System.out.println("\n====== MACHINE LOG ======");
        for (String entry : logs) {
            System.out.println(entry);
        }
        System.out.println("==========================\n");
    }

    public List<String> getLogs() {
        return logs;
    }
}
