package com.group18.oopprojectgroup18realestate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FinanceService handles saving/loading:
 * - Client Payments
 * - Vendor Payments
 * - Salary Records
 *
 * All stored using ObjectOutputStream / ObjectInputStream
 */
public class FinanceService {

    /* ========================================================
                      CLIENT PAYMENTS
       ======================================================== */

    private static final String PAYMENT_FILE = "payments.bin";

    public static List<Payment> loadPayments() {
        File f = new File(PAYMENT_FILE);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (List<Payment>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void savePayments(List<Payment> list) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(PAYMENT_FILE))) {
            out.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error saving payments.bin");
        }
    }

    public static void addPayment(Payment payment) {
        List<Payment> list = loadPayments();
        list.add(payment);
        savePayments(list);
    }



    /* ========================================================
                      VENDOR PAYMENTS
       ======================================================== */

    private static final String VENDOR_PAYMENT_FILE = "vendor_payments.bin";

    public static List<VendorPayment> loadVendorPayments() {
        File f = new File(VENDOR_PAYMENT_FILE);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (List<VendorPayment>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveVendorPayments(List<VendorPayment> list) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(VENDOR_PAYMENT_FILE))) {
            out.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error saving vendor_payments.bin");
        }
    }

    public static void addVendorPayment(VendorPayment vp) {
        List<VendorPayment> list = loadVendorPayments();
        list.add(vp);
        saveVendorPayments(list);
    }



    /* ========================================================
                      SALARY PAYMENTS
       ======================================================== */

    private static final String SALARY_FILE = "salaries.bin";

    public static List<SalaryRecord> loadSalaries() {
        File f = new File(SALARY_FILE);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (List<SalaryRecord>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveSalaries(List<SalaryRecord> list) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(SALARY_FILE))) {
            out.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error saving salaries.bin");
        }
    }

    public static void addSalary(SalaryRecord record) {
        List<SalaryRecord> list = loadSalaries();
        list.add(record);
        saveSalaries(list);
    }
    /* ========================================================
                      BUDGET RECORDS
   ======================================================== */

    private static final String BUDGET_FILE = "budgets.bin";

    public static List<BudgetRecord> loadBudgets() {
        File f = new File(BUDGET_FILE);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (List<BudgetRecord>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveBudgets(List<BudgetRecord> list) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(BUDGET_FILE))) {
            out.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error saving budgets.bin");
        }
    }

    public static void addBudget(BudgetRecord record) {
        List<BudgetRecord> list = loadBudgets();
        list.add(record);
        saveBudgets(list);
    }
}
