package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator.LogEntry;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LogService {

    //Path
    private static final String LOG_FILE = "logs.bin";

    public static List<LogEntry> loadLogs() {
        File file = new File(LOG_FILE);

        if (!file.exists()) return new ArrayList<>();

        //Read
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<LogEntry>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveLogs(List<LogEntry> logs) {
        //Write
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(LOG_FILE))) {
            out.writeObject(logs);
        } catch (Exception e) {
            System.out.println("Error saving logs.bin");
        }
    }

    //add new log
    public static void addLog(String message) {
        List<LogEntry> logs = loadLogs();

        logs.add(new LogEntry(LocalDate.now().toString(), message));

        saveLogs(logs);
    }
}
