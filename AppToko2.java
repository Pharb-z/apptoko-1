
import java.util.ArrayList;
import java.util.Scanner;

public class AppToko2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<cGoods> goodsList = new ArrayList<>();
        ArrayList<cBuyer> memberList = new ArrayList<>();
        // cGoods good = new cGoods();
        cBuyer buyer = new cBuyer();
        String idGoods;
        String name;
        double price;
        int stock;
        String idBuyer;
        String buyerName;
        String address;
        String perks;
        int memPoin = 0;
        int choice;
        int choice3;
        String nextAdd;
        String yorn;
        String chDelete;
        String delMember;
        String editPerks;
        String chIdPerks;
        boolean found = false;
        boolean chPerks = false;
        cBuyerManage.load(memberList);
        cGoodsList.load(goodsList);
        do {
            System.out.println("Store App");
            System.out.println("1. Goods\n2. Member\n3. Exit");
            System.out.print("Choose : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("  Goods Menu");
                    System.out.println("  1. Add");
                    System.out.println("  2. Read");
                    System.out.println("  3. Find Goods");
                    System.out.println("  4. Update");
                    System.out.println("  5. Delete");
                    System.out.println("  6. Back");
                    System.out.print("  Choose : ");
                    int choice2 = sc.nextInt();
                    sc.nextLine();
                    switch (choice2) {
                        case 1:
                            // good = new cGoods(101, "Rice", 18000, 100);
                            do {
                                System.out.print("ID    : ");
                                idGoods = sc.nextLine();
                                System.out.print("Name  : ");
                                name = sc.nextLine();
                                System.out.print("Price : ");
                                price = sc.nextDouble();
                                System.out.print("Stock : ");
                                stock = sc.nextInt();
                                System.out.print("Add " + name + " to goods list? (y/n)");
                                nextAdd = sc.next();
                            } while (!nextAdd.equalsIgnoreCase("y"));
                            goodsList.add(new cGoods(idGoods, name, price, stock));
                            System.out.println("Goods added!");
                            break;
                        case 2:
                                /*if ((good != null) && (good.getName()!=null)){
                                System.out.println(good.ToString());
                                } else{
                                System.out.println("Empty goods");
                                }*/
                            if (goodsList.isEmpty()) {
                                System.out.println("Empty goods!");
                            } else {
                                System.out.printf("%-5s %-10s %-36s %-10s %-10s\n",
                                        "No", "ID", "Name", "Price", "Stock");
                                System.out.println(
                                        "----------------------------------------------------------------------");

                                for (int i = 0; i < goodsList.size(); i++) {
                                    cGoods g = goodsList.get(i);
                                    System.out.printf("%-5d %-10s %-36s %-10.2f %-10d\n",
                                            (i + 1),
                                            g.getIdGoods(),
                                            g.getName(),
                                            g.getPrice(),
                                            g.getStock());
                                }
                            }
                            break;
                        case 3:
                            System.out.println(" ===Find Goods===");
                            System.out.print(" Input Goods ID or Name : ");
                            String scGoods = sc.nextLine();
                            cGoodsList.searchGoods(scGoods);
                            break;
                        case 4:
                                /*if(good != null){
                                System.out.print("New Price : ");
                                double nprice = sc.nextDouble();
                                good.setPrice(nprice);
                                }else{
                                System.out.println("Goods is empty!");
                                }*/
                            System.out.println("1. Update price");
                            System.out.println("2. Update stock");
                            System.out.print("Choose : ");
                            int chUpdate = sc.nextInt();
                            sc.nextLine();
                            switch (chUpdate) {
                                case 1:
                                    System.out.print("Input goods name or id to update price : ");
                                    String chPrice = sc.nextLine();
                                    cGoodsList.searchGoods(chPrice);
                                    for (cGoods g : goodsList) {
                                        if (g.getIdGoods().equalsIgnoreCase(chPrice)) {
                                            System.out.print("Input new price : ");
                                            price = sc.nextDouble();
                                            sc.nextLine();
                                            g.setPrice(price);
                                            System.out.println("Price updated!");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("Input goods name or id to update stock : ");
                                    String chStock = sc.nextLine();
                                    cGoodsList.searchGoods(chStock);
                                    for (cGoods g : goodsList) {
                                        if (g.getIdGoods().equalsIgnoreCase(chStock)) {
                                            System.out.print("Add new stock : ");
                                            stock = sc.nextInt();
                                            g.setStock(g.getStock() + stock);
                                            System.out.println("Stock updated!");
                                        }
                                    }
                                    break;
                            }
                            break;
                        case 5:
                            /*  System.out.println("Delete " + good.getName());
                                System.out.print("1. Yes or 2. No : ");
                                int confirm = sc.nextInt();
                                if(confirm == 1){
                                good = null;
                                System.out.println("Goods is deleted!");
                                }else{
                                System.out.println("Canceled!");
                                }*/
                            do {
                                System.out.print("Choose Goods ID to delete : ");
                                chDelete = sc.nextLine();
                                cGoodsList.searchGoods(chDelete);

                                System.out.println("");
                                System.out.print("Are you sure to delete this goods? (y/n) ");
                                yorn = sc.next();
                                sc.nextLine();
                            } while (!yorn.equalsIgnoreCase("y"));
                            cGoodsList.deleteGoods(goodsList, chDelete);

                            break;
                        case 6:
                            System.out.println("Back to Main...");
                    }
                    break;
                case 2:
                    System.out.println("  Member Menu");
                    System.out.println("  1. Add new member");
                    System.out.println("  2. Member list");
                    System.out.println("  3. Delete member");
                    System.out.println("  4. Find member");
                    System.out.println("  5. Edit member perks");
                    System.out.println("  6. Back");
                    System.out.print("  Choose : ");
                    choice3 = sc.nextInt();
                    sc.nextLine();
                    switch (choice3) {
                        case 1:
                            do {
                                System.out.println(" ===Add New Member===");
                                System.out.print(" ID      : ");
                                idBuyer = sc.nextLine();
                                System.out.print(" Name    : ");
                                buyerName = sc.nextLine();
                                System.out.print(" Address : ");
                                address = sc.nextLine();
                                System.out.print(" Perks   : ");
                                perks = sc.nextLine();
                                if (perks.equalsIgnoreCase("silver")) {
                                    memPoin = 200;
                                } else if (perks.equalsIgnoreCase("gold")) {
                                    memPoin = 500;
                                } else if (perks.equalsIgnoreCase("platinum")) {
                                    memPoin = 1000;
                                }
                                System.out.print("Add " + buyerName + " to new member(y/n) ");
                                nextAdd = sc.next();
                            } while (!nextAdd.equalsIgnoreCase("y"));
                            memberList.add(new cBuyer(idBuyer, buyerName, address, perks, memPoin));
                            break;
                        case 2:
                            System.out.println("======================== Member List ========================");

                            if (memberList.isEmpty()) {
                                System.out.println("Empty member!");
                            } else {

                                System.out.printf("%-5s %-15s %-15s %-15s %-10s \n",
                                        "No", "ID", "Name", "Address", "Perks");

                                System.out.println(
                                        "-------------------------------------------------------------");

                                for (int i = 0; i < memberList.size(); i++) {

                                    cBuyer m = memberList.get(i);

                                    System.out.printf("%-5d %-15s %-15s %-15s %-10s \n",
                                            (i + 1),
                                            m.getId(),
                                            m.getName(),
                                            m.getAddress(),
                                            m.getPerks());
                                    // m.getPoint());
                                }
                            }
                            break;
                        case 3:
                            System.out.println(" ===Delete Member===");
                            do {
                                System.out.print(" Input Member ID or Name : ");
                                delMember = sc.nextLine();
                                cBuyerManage.searchMember(delMember);
                                System.out.println("Are you sure to delete this member? (y/n)");
                                yorn = sc.next();
                                sc.nextLine();
                            } while (!yorn.equalsIgnoreCase("y"));
                            cBuyerManage.deleteMember(memberList, delMember);
                            break;
                        case 4:
                            System.out.println(" ===Find Member===");
                            System.out.print(" Enter member ID or Name: ");
                            String scMember = sc.nextLine();
                            cBuyerManage.searchMember(scMember);
                            break;
                        case 5:
                            System.out.println("===Edit Member Perks===");

                            cBuyer member = null;

                            do {
                                System.out.print("Input Member ID or Name : ");
                                chIdPerks = sc.nextLine();

                                member = cBuyerManage.verifBuyer(memberList, chIdPerks);

                                if (member == null) {
                                    System.out.println("Member not found!");
                                }

                            } while (member == null);

                            chPerks = false;
                            do {
                                System.out.print("Change member perks : ");
                                editPerks = sc.nextLine();

                                if (editPerks.equalsIgnoreCase("silver")
                                        || editPerks.equalsIgnoreCase("gold")
                                        || editPerks.equalsIgnoreCase("platinum")) {

                                    chPerks = true;

                                } else {
                                    System.out.println("Perks must be silver / gold / platinum");
                                }

                            } while (!chPerks);

                            if (editPerks.equalsIgnoreCase("silver")) {
                                member.setPerks("Silver");
                                member.setPoint(200);

                            } else if (editPerks.equalsIgnoreCase("gold")) {
                                member.setPerks("Gold");
                                member.setPoint(500);

                            } else if (editPerks.equalsIgnoreCase("platinum")) {
                                member.setPerks("Platinum");
                                member.setPoint(1000);
                            }

                            System.out.println("Member perks has changed!");

                            break;
                        case 6:
                            System.out.println("Back to Main...");
                    }
                    break;
                case 3:
                    cGoodsList.save(goodsList);
                    cBuyerManage.save(memberList);
                    System.out.println("Thank you!");
            }
        } while (choice != 3);
        sc.close();
    }
}
