import java.util.Scanner;
import java.util.ArrayList;
public class AppToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<cInvoice> invoiceList = new ArrayList<>();
        ArrayList<cGoods> goodsList = new ArrayList<>();
        ArrayList<cBuyer> memberList = new ArrayList<>();
        ArrayList<cCart> cart = new ArrayList<>();
        String inputId; String yorn = "y"; int qty = 0;
        boolean founde = false;
        cInvoiceManage.load(invoiceList);
        cGoodsList.load(goodsList);
        cBuyerManage.load(memberList);
        
        /*goodsList.get(29).setStock(goodsList.get(29).getStock()-1);
        System.out.println(goodsList.get(29));*/
        System.out.println("===Welcome to 6 Seven Market===");
        do{
            System.out.print("Input goods ID : ");
            inputId = sc.nextLine();
            cGoods g = cGoodsList.cartGoods(goodsList, inputId);
            cGoodsList.scCart(inputId);
            if(g != null){
            System.out.print("Input Quantity : ");
            qty = sc.nextInt();
            sc.nextLine();
            if(qty > g.getStock()){
                System.out.println("Stock not enough");
            }else if(qty > 0 && qty <= g.getStock()){
                for(cCart c : cart){
                    if(c.getGoods().getIdGoods().equalsIgnoreCase(g.getIdGoods())){
                    c.addQty(qty);
                    founde = true;
                    break;
                    }
                }
                if(!founde){
                    cart.add(new cCart(g, qty));
                }
                for(cCart c : cart){
                    System.out.println(c);
                }
                g.setStock(g.getStock() - qty);
                System.out.println(" Goods added!");
            }else{
                System.out.println("Error quantity!");
            }
            }else{
                System.out.println("Goods not found!");
            }
            System.out.print("Add new goods? (y/n) ");
            yorn = sc.nextLine();
        } while(yorn.equalsIgnoreCase("y"));
        System.out.print("Today cashier : ");
        String cashier = sc.nextLine();
        System.out.println("===== 6 SEVEN MARKET INVOICE =====");
        double total = 0;
        System.out.println("----------------------------------");
        for(cCart c : cart){
            System.out.println(c);
            total += c.getSubtotal();
        }
        System.out.println("----------------------------------");
        int orderNumber = invoiceList.size() + 1;
        cInvoice invc = new cInvoice(cashier, total, orderNumber);
        System.out.println(invc);
        System.out.println("Total : Rp." + total);
        cGoodsList.save(goodsList);
        cInvoiceManage.save(invoiceList);
        
        }
}
