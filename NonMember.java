public class NonMember extends Customer
{
    private String ICNumber;
    private String gender;
    
    public NonMember(String name,String phoneNum, String email,Booking b,String ICNumber,String gender)
    {
        super(name, phoneNum, email, b);
        this.ICNumber = ICNumber;
        this.gender = gender;
    }
    
    public void setICNumber(String ICNumber)
    {
        this.ICNumber = ICNumber;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public String getICNumber()
    {
        return ICNumber;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public double calcPrice()
    {
        double total = super.calcPrice();
        return total;
    }
    
    public String toString()
    {
        String value = super.toString()+
                       "\nCustomer IC number : " +ICNumber +
                       "\nCustomer gender : " + gender;
        return value;
    }
}