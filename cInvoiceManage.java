import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
public class cInvoiceManage {
    public static void save(List<cInvoice> invoiceList){
        try{
            FileWriter writer = new FileWriter("invoice.txt");
            for (cInvoice inv : invoiceList){
                writer.write(inv.getCode()+ "," + inv.getTotal() + "," + inv.getCashier() + "\n");
            }
            writer.close();
            System.out.println("Invoice saved!");
        }catch(Exception e){
            System.out.println("Error saving invoice!");
        }
    }
    public static void load (List<cInvoice> invoiceList){
    
    try{
        File file = new File("invoice.txt");
        Scanner read = new Scanner(file);
        invoiceList.clear();

        while(read.hasNextLine()){
            String line = read.nextLine();
            String[] data = line.split(",");
            
            String cashier = data[2];
            double total = Double.parseDouble(data[1]);

            cInvoice inv = new cInvoice(cashier, total, invoiceList.size()+1);
            invoiceList.add(inv);
        }

        read.close();
    }catch(Exception e){
        System.out.println("Error loading invoice!");
    }

    
}
    public static void searchInvoice(String targetCode){
        try{File file = new File("invoice.txt");
        Scanner read = new Scanner(file);
        boolean found = false;
        while(read.hasNextLine()){
            String line = read.nextLine();
            String[] data = line.split(",");
            String code = data[0];
            String total = data[1];
            String cashier = data[2];
            
            if(code.equalsIgnoreCase(targetCode)){
                System.out.println("=====Invoice found!=====");
                System.out.println(" Invoice Number : " + code);
                System.out.println(" Total          : " + total);
                System.out.println(" Cashier        : " + cashier);
                found = true;
                break;
                }
            }
        if(!found){
            System.out.println("Invoice not found!");
            }
        read.close();
        }catch(Exception e){
            System.out.println("Error searching invoice!");
        }
    }
       
}

