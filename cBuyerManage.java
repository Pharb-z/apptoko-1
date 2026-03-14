import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class cBuyerManage {

    public static void save(List<cBuyer> memberList) {
        try {
            FileWriter writer = new FileWriter("member.txt");

            for (cBuyer mem : memberList) {
                writer.write(mem.getId() + "," +
                        mem.getName() + "," +
                        mem.getAddress() + "," +
                        mem.getPerks() + "," +
                        mem.getPoint() + "\n");
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving member!");
        }
    }

    public static void load(List<cBuyer> memberList) {
        try {
            File file = new File("member.txt");

            if (!file.exists()) {
                return;
            }

            Scanner reader = new Scanner(file);
            memberList.clear();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(",");

                String idMember = data[0];
                String buyerName = data[1];
                String address = data[2];
                String perks = data[3];
                int memPoin = Integer.parseInt(data[4]);

                cBuyer mem = new cBuyer(idMember, buyerName, address, perks, memPoin);
                memberList.add(mem);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error load member list!");
        }
    }

    public static void searchMember(String targetMember) {
        try {
            File file = new File("member.txt");
            Scanner reader = new Scanner(file);
            boolean found = false;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(",");

                String idMember = data[0];
                String buyerName = data[1];
                String address = data[2];
                String perks = data[3];
                String memPoin = data[4];

                if (buyerName.equalsIgnoreCase(targetMember) || idMember.equalsIgnoreCase(targetMember)) {
                    System.out.println("  =====Member Data=====");
                    System.out.println("  ID      : " + idMember);
                    System.out.println("  Name    : " + buyerName);
                    System.out.println("  Address : " + address);
                    System.out.println("  Perks   : " + perks);
                    System.out.println("  Point   : " + memPoin);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Member not found!");
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error search member!");
        }
    }
}