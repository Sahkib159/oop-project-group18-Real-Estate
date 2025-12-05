package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.Property;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyService {

    //Path
    private static final String FILE_PATH = "properties.bin";

   //returns ALL properties which are stored in "Properties.bin"
    public static List<Property> loadProperties() {
        File f = new File(FILE_PATH);
        if (!f.exists()) return new ArrayList<>();

        //Read
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Property>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    //Save new Properties in "Properties.bin"
    public static void saveProperties(List<Property> properties) {
        //Write
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(properties);
        } catch (Exception e) {
            System.out.println("Error saving properties.bin");
        }
    }
}
