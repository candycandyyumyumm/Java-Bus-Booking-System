public class Customer
{
    private String name;
    private String phoneNum;
    private String email;
    private Booking b;
    
    public Customer(String name,String phoneNum,String email, Booking b)
    {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.b = b;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setBooking(Booking b) 
    {
        this.b = b;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPhoneNum()
    {
        return phoneNum;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public Booking getBooking() 
    {
        return b;
    }
    
    public double calcPrice()
    {
        double total = 0.0;
        if(b != null)
           total = b.calcPrice();
        return total;
    }
    
    public String toString()
    {
        String value = "Customer Name : " + name +
                       "\nCustomer Phone Number : " + phoneNum +
                       "\nCustomer Email : " + email+
                       "\nBooking Details" + "\n" + b.toString();
        return value;
    }
}