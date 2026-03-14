public class cBuyer {
    private String idBuyer;
    private String buyerName;
    private String address;
    private String perks;
    private int memPoin;
    cBuyer(){
        System.out.println("Buyer object is created...");
    }
    cBuyer(String i, String n, String a, String p, int mp){
        idBuyer = i; buyerName = n; address = a; perks = p;  memPoin = mp;
        
    }
    public void setAddress(String a){
        address = a;
    }
    public void setPerks(String p){
        perks = p;
    }
    public void setPoint(int mp){
        memPoin = mp;
    }
    public String getId(){return idBuyer; }
    public String getName(){return buyerName; }
    public String getAddress(){return address; }
    public String getPerks(){return perks; }
    public int getPoint(){return memPoin; }
    @Override
    public String toString(){
        return "[" + idBuyer + "] |" + buyerName + "| |" + address + "| |" + perks + "|";
    } 
}
