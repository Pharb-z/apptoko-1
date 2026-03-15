import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class cInvoiceManage {
    public static void save(List<cInvoice> invoiceList) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("invoice.txt"));

            for (cInvoice i : invoiceList) {
                pw.println(i.getCode() + "," +
                        i.getTotal() + "," +
                        i.getCashier() + "," +
                        i.getBuyer());
            }

            pw.close();
            System.out.println("Invoice saved!");

        } catch (IOException e) {
            System.out.println("Error saving invoice");
        }
    }

    public static void load(List<cInvoice> invoiceList) {

        try {
            File file = new File("invoice.txt");
            Scanner read = new Scanner(file);
            invoiceList.clear();

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] data = line.split(",");
                if (data.length == 4) {
                    String code = data[0];
                    double total = Double.parseDouble(data[1]);
                    String buyer = data[2];
                    String cashier = data[3];

                    cInvoice inv = new cInvoice(code, total, buyer, cashier);
                    invoiceList.add(inv);
                }
            }

            read.close();
        } catch (Exception e) {
            System.out.println("Error loading invoice!");
        }

    }

    public static void searchInvoice(String targetCode) {
        try {
            File file = new File("invoice.txt");
            Scanner read = new Scanner(file);
            boolean found = false;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] data = line.split(",");
                String code = data[0];
                String total = data[1];
                String cashier = data[2];
                String buyer = data[3];

                if (code.equalsIgnoreCase(targetCode)) {
                    System.out.println("=====Invoice found!=====");
                    System.out.println(" Invoice Number : " + code);
                    System.out.println(" Total          : " + total);
                    System.out.println(" Cashier        : " + cashier);
                    System.out.println(" Buyer          : " + buyer);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invoice not found!");
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error searching invoice!");
        }
    }

}
