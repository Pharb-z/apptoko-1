public class cCart {
    private cGoods goods;
    private int qty;
    public cCart(cGoods goods, int qty){
        this.goods = goods;
        this.qty = qty;
    }
    public void addQty(int qty){
        this.qty += qty;
    }
    public double getSubtotal(){
        return goods.getPrice()*qty;
    }
    public cGoods getGoods(){
        return goods;
    }
    public int getQty(){
        return qty;
    }
    @Override
    public String toString(){
        return "[" + goods.getIdGoods() + "] "
                + goods.getName()
                + " | Rp." + goods.getPrice() 
                + " | Qty: " + qty
                + " | Subtotal: " + getSubtotal();
    }
}
