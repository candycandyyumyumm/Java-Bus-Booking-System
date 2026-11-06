public class Booking
{
    private String travelDate;
    private String seatNum;
    private String destination;
    private String travelTime;
    
    public Booking(String travelDate, String seatNum, String destination, String travelTime)
    {
        this.travelDate = travelDate;
        this.seatNum = seatNum;
        this.destination = destination;
        this.travelTime = travelTime;
    }
    
    public void setTravelDate(String travelDate)
    {
        this.travelDate = travelDate;
    }
    
    public String getTravelDate()
    {
        return travelDate;
    }
    
    public void setSeatNum(String seatNum)
    {
        this.seatNum = seatNum;
    }
    
    public String getSeatNum()
    {
        return seatNum;
    }
    
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public void setTravelTime(String travelTime)
    {
        this.travelTime = travelTime;
    }
    
    public String getTravelTime()
    {
        return travelTime;
    }
    
    public void bookTicket()
    {
        System.out.println("==================BOOKING SUCCESS==============");
        System.out.println("Destination : " + destination);
        System.out.println("Travel Date : " + travelDate);
        System.out.println("Travel Time : " + travelTime);
        System.out.println("Seat Number : " + seatNum);
        System.out.println("===============================================");
    }
    
    public double calcPrice()
    {
        double price = 0;
        if(destination == null)
          return price;
        else if(destination.equalsIgnoreCase("TBG"))
           price = 25;
        else if(destination.equalsIgnoreCase("Georgetown"))
           price = 30;
        else if(destination.equalsIgnoreCase("Ipoh"))
           price = 27.5;
        else if(destination.equalsIgnoreCase("Seremban"))
           price = 20;
        else if(destination.equalsIgnoreCase("Raub"))
           price = 15;
           
        return price;
    }
    
    public String toString()
    {
        String value = " ";
        value = "\nDestination : " + destination + 
                "\nTravel Date : " + travelDate +
                "\nTravel Time : " + travelTime +
                "\nSeat Number : " + seatNum;
        return value;
    }
}