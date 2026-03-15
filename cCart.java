public class cCart {
    private cGoods goods;
    private int qty;

    public cCart(cGoods goods, int qty) {
        this.goods = goods;
        this.qty = qty;
    }

    public void addQty(int qty) {
        this.qty += qty;
    }

    public double getSubtotal() {
        return goods.getPrice() * qty;
    }

    public cGoods getGoods() {
        return goods;
    }

    public int getQty() {
        return qty;
    }

    public static void printHeader() {
        System.out.println("+----------+--------------------------------------+------------+-------+------------+");
        System.out.println("| ID       | NAME                                 | PRICE      | QTY   | SUBTOTAL   |");
        System.out.println("+----------+--------------------------------------+------------+-------+------------+");
    }

    @Override
    public String toString() {
        return String.format("| %-8s | %-36s | %-10.0f | %-5d | %-10.0f |",
                goods.getIdGoods(),
                goods.getName(),
                goods.getPrice(),
                qty,
                getSubtotal());
    }
    public static void printFooter() {
        System.out.println("+----------+--------------------------------------+------------+-------+------------+");
    }
}
