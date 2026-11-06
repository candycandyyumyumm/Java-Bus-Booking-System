public class Member extends Customer
{
    private double promo;
    private double discount;
    
    public Member(String name,String phoneNum,String email,Booking b,double promo,double discount)
    {
        super(name, phoneNum, email, b);
        this.promo = promo;
        this.discount = discount;
    }
    
    public void setPromo(double promo)
    {
        this.promo = promo;
    }
    
    public void setDiscount(double discount)
    {
        this.discount = discount;
    }
    
    public double getPromo()
    {
        return promo;
    }
    
    public double getDiscount()
    {
        return discount;
    }
    
    public double calcPrice()
    {
        double price = super.calcPrice();
        double total = price - (price * discount);
        total = total - promo;
        return total;
    }
    
    public String toString()
    {
        String value = super.toString() +
                       "\nTotal Discount : " + discount +
                       "\nTotal Promotion : " + promo;
        return value;
    }
}