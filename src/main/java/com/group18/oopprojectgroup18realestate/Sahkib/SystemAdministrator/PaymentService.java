package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import com.group18.oopprojectgroup18realestate.Payment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    //Path
    private static final String FILE_PATH = "payments.bin";

    public static List<Payment> loadPayments() {
        File f = new File(FILE_PATH);
        if (!f.exists()) return new ArrayList<>();

        //Read
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Payment>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void savePayments(List<Payment> payments) {
        //Write
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(payments);
        } catch (Exception e) {
            System.out.println("Error saving payments.bin");
        }
    }
}
