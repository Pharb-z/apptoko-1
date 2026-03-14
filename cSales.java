public class cSales {
    private int code;
    private cGoods goods;
    private cBuyer buyer;
    private int qty;
    private double total;
    cSales(){}
    public void addSales(int c, cGoods g, cBuyer b, int q){
        code = c; goods = g; buyer = b; qty= q;
        total = qty*goods.getPrice();
    }
    public void printSales(){
        System.out.println("Sales");
        System.out.println("Code   : " + code);
        System.out.println("Goods  : " + goods);
        System.out.println("Buyer  : " + buyer);
        System.out.println("Quantity : " + qty);
        System.out.println("Price    : " + goods.getPrice());
        System.out.println("Total    : " + total);
    }
}
