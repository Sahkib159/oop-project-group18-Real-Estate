package com.group18.oopprojectgroup18realestate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    //Path
    private static final String FILE_PATH = "users.bin";


    //returns ALL users which are stored in users.bin
    public static List<User1> loadUsers() {

        //If users.bin does NOT exist it returns an empty list.
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        //Reads binary file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            //Converts .bin back into List<User1>
            return (List<User1>) in.readObject();
        } catch (Exception e) {
            //If file is corrupted or empty, it returns empty list.
            return new ArrayList<>();
        }
    }

    //Saves the full list of users back into users.bin.
    public static void saveUsers(List<User1> users) {

        //Converts the Entire ArrayList<User1> into binary than Writes it to users.bin also Overwrites old file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(users);
        } catch (Exception e) {
            System.out.println("Error saving users.bin");
        }
    }

    //add a new account
    public static void addUser(User1 user) {
        //Load existing users
        List<User1> list = loadUsers();
        //Add the new user
        list.add(user);
        //Save all users again
        saveUsers(list);
    }
}
