
import java.util.ArrayList;
import java.util.Scanner;

public class AppToko {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<cInvoice> invoiceList = new ArrayList<>();
        ArrayList<cGoods> goodsList = new ArrayList<>();
        ArrayList<cBuyer> memberList = new ArrayList<>();
        ArrayList<cCart> cart = new ArrayList<>();
        String inputId;
        String yorn = "y";
        int qty = 0;
        boolean founde = false;
        boolean cekMember = false;
        cInvoiceManage.load(invoiceList);
        cGoodsList.load(goodsList);
        cBuyerManage.load(memberList);

        /*goodsList.get(29).setStock(goodsList.get(29).getStock()-1);
        System.out.println(goodsList.get(29));*/
        System.out.println("===Welcome to 6 Seven Market===");
        do {
            System.out.print("Input goods ID : ");
            inputId = sc.nextLine();
            cGoods g = cGoodsList.cartGoods(goodsList, inputId);
            cGoodsList.scCart(inputId);
            if (g != null) {
                System.out.print("Input Quantity : ");
                qty = sc.nextInt();
                sc.nextLine();
                if (qty > g.getStock()) {
                    System.out.println("Stock not enough");
                } else if (qty > 0 && qty <= g.getStock()) {
                    for (cCart c : cart) {
                        if (c.getGoods().getIdGoods().equalsIgnoreCase(g.getIdGoods())) {
                            c.addQty(qty);
                            founde = true;
                            break;
                        }
                    }
                    if (!founde) {
                        cart.add(new cCart(g, qty));
                    }
                    cCart.printHeader();
                    for (cCart c : cart) {
                        System.out.println(c);
                    }
                    cCart.printFooter();
                    g.setStock(g.getStock() - qty);
                    System.out.println(" Goods added!");
                }
            } else {
                System.out.println("Goods not found!");
            }
            System.out.print("Add new goods? (y/n) ");
            yorn = sc.nextLine();
        } while (yorn.equalsIgnoreCase("y"));
        System.out.print("Buyer Name : ");
        String bName = sc.nextLine();
        System.out.print("Today cashier : ");
        String cashier = sc.nextLine();
        System.out.println("=============================== 6 SEVEN MARKET INVOICE ===============================");
        double total = 0;
        double disc = 0;
        double totalDiscount = 0;
        int poin = 0;
        cBuyer mm = cBuyerManage.verifBuyer(memberList, bName);
        int orderNumber = invoiceList.size() + 1;
        cInvoice invc = new cInvoice(cashier, bName, total, orderNumber);
        System.out.println("|" + invc + "                                                                   |");
        invoiceList.add(invc);
        if (mm != null) {
            System.out.println("| Customer  : " + mm.getName());
            System.out.println("| Member    : " + mm.getPerks());
            cekMember = true;
        } else {
            System.out.println("| Customer  : " + bName);
            System.out.println("| Member    : None");
        }
        System.out.println("--------------------------------------------------------------------------------------");
        for (cCart c : cart) {
            System.out.println(c);
            total += c.getSubtotal();
        }
        System.out.println("--------------------------------------------------------------------------------------");
        if (!cekMember) {

        } else {
            if (mm.getPerks().equalsIgnoreCase("silver") && total > 200000) {
                disc = 10;
                
            } else if (mm.getPerks().equalsIgnoreCase("gold") && total > 150000) {
                disc = 15;
                
            } else if (mm.getPerks().equalsIgnoreCase("platinum") && total > 150000) {
                disc = 20;
                
            } else if (mm.getPerks().equalsIgnoreCase("bronze") && total > 200000) {
                disc = 5;
                
            }else{
                
            }
            
            totalDiscount = total - (total * (disc / 100.0));
            poin = (int) (totalDiscount / 1000);
            mm.setPoint(mm.getPoint() + poin);
            if (mm.getPoint() >= 0 && mm.getPoint() < 200) {
                String perks = "Bronze";
                mm.setPerks(perks);
            } else if (mm.getPoint() >= 200 && mm.getPoint() < 500) {
                String perks = "Silver";
                mm.setPerks(perks);
            } else if (mm.getPoint() >= 500 && mm.getPoint() < 1000) {
                String perks = "Gold";
                mm.setPerks(perks);
            } else if (mm.getPoint() >= 1000) {
                String perks = "Platinum";
                mm.setPerks(perks);
            }
        }
        System.out.printf("| %-8s : %-36.0f  %-10s  %-8s  %-11s |\n", "Before", total, "", "", "");
        System.out.printf("| %-8s : %-36.0f  %-10s  %-8s  %-11s |\n", "Discount", disc, "", "", "");
        System.out.printf("| %-8s : %-36.0f  %-10s  %-8s  %-11s |\n", "Total", totalDiscount, "", "", "");
        System.out.println("| You got " + poin + " point from this transaction");
        System.out.println("--------------------------------------------------------------------------------------");
        cGoodsList.save(goodsList);
        cInvoiceManage.save(invoiceList);
        cBuyerManage.save(memberList);
        sc.close();
    }
}
