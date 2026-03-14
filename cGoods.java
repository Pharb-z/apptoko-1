public class cGoods {
    // data
    private String idGoods;
    private String name;
    private double price;
    private int stock;

    // methods
    cGoods() {
        System.out.println("This is default constructor...");
    }

    cGoods(String i, String n, double p, int s) {
        idGoods = i;
        name = n;
        price = p;
        stock = s;

    }

    // Getter
    public String getIdGoods() {
        return idGoods;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setter
    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // query
    @Override
    public String toString() {
        return "[" + idGoods + "] |" + name + "| |Rp." + price + "| |" + stock + " pcs|";

    }
}
