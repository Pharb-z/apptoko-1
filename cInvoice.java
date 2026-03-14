import java.time.LocalDate;
public class cInvoice {
    private String code;
    private String cashier;
    private double total;
    public cInvoice(String cashier, double total, int orderNumber){
    LocalDate now = LocalDate.now();
    String day = now.getDayOfWeek().toString().substring(0,3);
    String date = String.format("%02d", now.getDayOfMonth());
    String month = String.format("%02d", now.getMonthValue());
    String year = String.valueOf(now.getYear()).substring(2);
    String order = String.format("%04d", orderNumber);
    String cashierCode = cashier.substring(0,2).toUpperCase();
    this.code = day + date + month + year + order + cashierCode;
    this.cashier = cashier;
    this.total = total;
}
    public void setCashier(String c){
        cashier = c;
    }
    public String getCode(){
        return code;
    }
    public double getTotal(){
        return total;
    }
    public String getCashier(){
        return cashier;
    }
    @Override
    public String toString(){
        return "[" + code + "]";
    }
}