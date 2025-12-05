package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator.Issue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IssueService {

    //path
    private static final String FILE_PATH = "issues.bin";

    public static List<Issue> loadIssues() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

       //Read
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Issue>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveIssues(List<Issue> issues) {
        //Write
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(issues);
        } catch (Exception e) {
            System.out.println("Error saving issues.bin");
        }
    }
}
