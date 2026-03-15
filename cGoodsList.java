import java.io.FileWriter;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
public class cGoodsList {
    public static void save(List <cGoods> goodsList) {
        try {
            FileWriter writer = new FileWriter("goods.txt");
                    for (cGoods g : goodsList){
                        writer.write(g.getIdGoods() + "," + g.getName() + "," + g.getPrice() + "," + g.getStock() + "\n");
                    }
                    writer.close();
                    System.out.println("Data saved!");
        }catch (Exception e){
            System.out.println("Error saving files!");
        }
    }
    public static void load(List <cGoods> goodsList) {
        try{
            File file = new File("goods.txt");
            Scanner reader = new Scanner(file);
            goodsList.clear();
            
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split(",");
                String idGoods = (data[0]);
                String name = (data[1]);
                double price = Double.parseDouble(data[2]);
                int stock = Integer.parseInt(data[3]);
                cGoods g = new cGoods(idGoods, name, price, stock);
                goodsList.add(g);
            }
            reader.close();
            System.out.println("Data loaded!");
        }catch(Exception e){
            System.out.println("Error reading file!"); 
        }
    }
    public static void searchGoods(String targetGoods){
    try{
        File file = new File("goods.txt");
        Scanner reader = new Scanner(file);
        boolean found = false;
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] data = line.split(",");
            String id = data[0];
            String name = data[1];
            String price = data[2];
            String stock = data[3];
            if(name.equalsIgnoreCase(targetGoods)){
            System.out.println("  =====Goods Name=====");
            System.out.println("  ID    : " + id);
            System.out.println("  Name  : " + name);
            System.out.println("  Price : " + price);
            System.out.println("  Stock : " + stock);
            found = true;
            break;
    }else if(id.equalsIgnoreCase(targetGoods)){
            System.out.println("  =====Goods Name=====");
            System.out.println("  ID    : " + id);
            System.out.println("  Name  : " + name);
            System.out.println("  Price : " + price);
            System.out.println("  Stock : " + stock);
            found = true;
            break;
    }
        }
        if(!found){
            System.out.println("Goods not found!");
        }
}catch(Exception e){
    
}
    
}
    public static void deleteGoods(List<cGoods> goodsList, String targetGoods){
    Iterator<cGoods> it = goodsList.iterator();
    boolean found = false;
    
    while(it.hasNext()){
        cGoods g = it.next();
        if(g.getIdGoods().equalsIgnoreCase(targetGoods)){
            it.remove();
            found = true;
            break;
        }
    }
    if(found){
        System.out.println("Goods deleted!");
    }else{
        System.out.println("Can't find goods!");
    }
}
   public static cGoods cartGoods(List<cGoods> goodsList, String id){
       for(cGoods g : goodsList){
           if(g.getIdGoods().equalsIgnoreCase(id)){
               return g;
           }
       }
   return null;
   }
   public static void scCart(String targetGoods){
       try{
        File file = new File("goods.txt");
        Scanner reader = new Scanner(file);
        boolean found = false;
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] data = line.split(",");
            String id = data[0];
            String name = data[1];
            String price = data[2];
            if(id.equalsIgnoreCase(targetGoods)){
            System.out.println("[" + id + "] |" + name + "| |Rp." + price);
            found = true;
            break;
    }
       }
   }catch(Exception e){
           System.out.println("Goods not found!");
        }
        
   }
   
}
