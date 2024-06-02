package javaapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLog implements Log {
    private static final String LOG_FILE_NAME = "coffee_machine_log.txt";
    private final File logFile;

    public FileLog() {
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        this.logFile = new File(path, LOG_FILE_NAME);
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String msg) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(msg);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
