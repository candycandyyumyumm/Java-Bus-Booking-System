import java.util.*;
import java.io.*; //must have io java class
public class CustomerAppWithFile
{
    public static void main(String args[]) throws IOException //must throws IOException for file input/output 
    {   
        try{ //start try
        //declare an array of object with size of 20
        Customer [] cust = new Customer[20];
        
        //insert data from customer.txt into array of object and to open input file
        FileReader fr=new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);
        
        int count=0;
        StringTokenizer st=null;
        String dataRow=br.readLine(); //to read line by line of data
        while(dataRow!=null)            //to make sure read until the end of data
        {   st=new StringTokenizer(dataRow,";"); //to cut the word based on ";"    <-----   delimiter
            
            //Personal information
            String name=st.nextToken();
            String phoneNum=st.nextToken();
            String email=st.nextToken();
            
            //Member or non-member
            String type=st.nextToken();
            
            //Booking information
            String travelDate=st.nextToken(); 
            String seatNum=st.nextToken();
            String destination=st.nextToken();
            String travelTime=st.nextToken();
            
            Booking b = new Booking(travelDate,seatNum,destination,travelTime);
            
            if(type.equalsIgnoreCase("Member"))
            {
                double promo = Double.parseDouble(st.nextToken());
                double discount = Double.parseDouble(st.nextToken());
                
                cust[count] = new Member(name,phoneNum,email, new Booking(travelDate,seatNum,destination,travelTime),promo,discount);
            }
            else if(type.equalsIgnoreCase("NonMember"))
            {
                String ICNum = st.nextToken();
                String gender = st.nextToken();
                cust[count]=new NonMember(name,phoneNum,email,new Booking(travelDate,seatNum,destination,travelTime),ICNum,gender);
            }
            
            count++;
            dataRow = br.readLine(); //to read new data line
        }
        br.close();//close input file
        
        //Update info email / PhoneNum
        
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("==================================================================================");
        System.out.println("        CUSTOMER INFORMATION EMAIL / PHONE NUMBER / SEATING AREA CHANGES          ");
        System.out.println("==================================================================================");
        System.out.print("Do you want to change any customer information ? [YES/NO] : ");
        String choice = input.nextLine();
        if(choice.equalsIgnoreCase("Yes"))
        {
            int found = -1;
            System.out.print("Enter Customer Name : ");
            String custName = input.nextLine();
            
            for(int i=0; i<cust.length;i++)
            {
                if(cust[i] != null && cust[i].getName().equalsIgnoreCase(custName))
                {
                    found = i;
                    
                    System.out.print("Current Customer Details:");
                    System.out.println(" Name : " + cust[i].getName());
                    System.out.println(" Email : " + cust[i].getEmail());
                    System.out.println(" Phone Number : " + cust[i].getPhoneNum());
                    System.out.println(" Seating Area : " + cust[i].getBooking().getSeatNum());
                    
                    System.out.println("OPTION TO UPDATE CUSTOMER INFORMATION");
                    System.out.println("1. Customer Email");
                    System.out.println("2. Customer Phone Number");
                    System.out.println("3. Customer Seating Area:");
                    System.out.print("Enter choice to update customer information : ");
                    int update = input.nextInt();
                    input.nextLine();
                    //scanner.nextLine() // to clear buffer
                    
                    if(update == 1)
                    {
                        System.out.print("Enter new email: ");
                        String newEmail = input.nextLine();
                        cust[i].setEmail(newEmail); 
                    }
                    else if(update == 2)
                    {
                        System.out.print("Enter new phone number: ");
                        String newPhoneNum = input.nextLine();
                        cust[i].setPhoneNum(newPhoneNum); 
                    }
                    else if(update == 3)
                    {
                        System.out.println("================SUPER BUS SEATING MAP===================");
                        System.out.println("[FRONT DOOR]                   [DRIVER BUS]");
                        System.out.println("---------------------------------------------");
                        System.out.println("[  A1  ][  A2  ]         [   A3   ][  A4  ]");
                        System.out.println("---------------------------------------------");
                        System.out.println("[  B1  ][  B2  ]         [   B3   ][  B4  ]");
                        System.out.println("---------------------------------------------");
                        System.out.println("[  C1  ][  C2  ]         [   C3   ][  C4  ]");
                        System.out.println("---------------------------------------------");
                        System.out.println("[  D1  ][  D2  ]         [   D3   ][  D4  ]");
                        System.out.println("---------------------------------------------");
                        System.out.println("[  E1  ][  E2  ]         [   E3   ][  E4  ]");
                        System.out.println("---------------------------------------------");
                        
                        System.out.print("Enter new seating area: ");
                        String newSeatingArea = input.nextLine();
                        cust[i].getBooking().setSeatNum(newSeatingArea);  
                    }
                    else
                        System.out.println("NO CHANGES MADE");
                    break; // to exit loop found
                }
            }
            
            if(found == -1)
            {
                System.out.println("CUSTOMER NOT FOUND");
            }
            
        }
        
        
        // display all the detail of customer in the input file on output file
        FileWriter fwData=new FileWriter("CustData.txt");
        BufferedWriter bwData=new BufferedWriter(fwData);
        PrintWriter pwData=new PrintWriter(bwData);
        pwData.println("==================================================================================");
        pwData.println("               List of Details Customers using Super Bus System                   ");
        pwData.println("==================================================================================");
        for(int i = 0; i < cust.length; i++) 
        {
            if(cust[i] != null)
            pwData.println(cust[i].toString());
        }
        pwData.close();
        
        //display on output file the list of customer to bus drivers
        
        FileWriter fwRaub = new FileWriter("raub.txt");
        BufferedWriter bwRaub=new BufferedWriter(fwRaub);
        PrintWriter pwRaub=new PrintWriter(bwRaub);
        
        pwRaub.println("==================================================================================");
        pwRaub.println("                   List of Customers going to Raub                   ");
        pwRaub.println("==================================================================================");
        for(int i=0;i<cust.length;i++)
        {
            if(cust[i] != null && cust[i].getBooking().getDestination().equalsIgnoreCase("Raub"))
            pwRaub.println(cust[i].toString());
        }
        pwRaub.close();
        
        FileWriter fwIpoh = new FileWriter("ipoh.txt");
        BufferedWriter bwIpoh=new BufferedWriter(fwIpoh);
        PrintWriter pwIpoh=new PrintWriter(bwIpoh);
        
        pwIpoh.println("==================================================================================");
        pwIpoh.println("                   List of Customers going to Ipoh                   ");
        pwIpoh.println("==================================================================================");
        for(int i=0;i<cust.length;i++)
        {
            if(cust[i] != null && cust[i].getBooking().getDestination().equalsIgnoreCase("Ipoh"))
            pwIpoh.println(cust[i].toString());
        }
        pwIpoh.close();
        
        FileWriter fwTBG=new FileWriter("TBG.txt");
        BufferedWriter bwTBG=new BufferedWriter(fwTBG);
        PrintWriter pwTBG=new PrintWriter(bwTBG);
        
        pwTBG.println("===================================================================================");
        pwTBG.println("            List of Customers going to Terminal Bersepadu Gombak                  ");
        pwTBG.println("==================================================================================");
        for(int i=0;i<cust.length;i++)
        {
            if(cust[i] != null && cust[i].getBooking().getDestination().equalsIgnoreCase("TBG"))
            pwTBG.println(cust[i].toString());
        }
        pwTBG.close();
        
        FileWriter fwTown=new FileWriter("georgetown.txt");
        BufferedWriter bwTown=new BufferedWriter(fwTown);
        PrintWriter pwTown=new PrintWriter(bwTown);
        
        pwTown.println("==================================================================================");
        pwTown.println("                 List of Customers going to Georgetown                            ");
        pwTown.println("==================================================================================");
        for(int i=0;i<cust.length;i++)
        {
            if(cust[i] != null && cust[i].getBooking().getDestination().equalsIgnoreCase("georgetown"))
            pwTown.println(cust[i].toString());
        }
        pwTown.close();
        
        FileWriter fwSer=new FileWriter("Seremban.txt");
        BufferedWriter bwSer=new BufferedWriter(fwSer);
        PrintWriter pwSer=new PrintWriter(bwSer);
        
        pwSer.println("==================================================================================");
        pwSer.println("                 List of Customers going to Seremban                            ");
        pwSer.println("==================================================================================");
        for(int i=0;i<cust.length;i++)
        {
            if(cust[i] != null && cust[i].getBooking().getDestination().equalsIgnoreCase("Seremban"))
            pwSer.println(cust[i].toString());
        }
        pwSer.close();
        
        //CUSTOMER RECEIPT
        for(int i=0;i<cust.length;i++)
        {
           if(cust[i] != null)
           {
             String FileName = cust[i].getName() + ".txt";
           
             FileWriter fwIn=new FileWriter(FileName);
             BufferedWriter bwIn=new BufferedWriter(fwIn);
             PrintWriter pwIn=new PrintWriter(bwIn);
        
             pwIn.println("==================================================================================");
             pwIn.println("                           SUPER BUS SYSTEM RECEIPT                               ");
             pwIn.println("==================================================================================");
             
             pwIn.println(cust[i].toString()); 
             pwIn.printf("Total price : %.2f\n",cust[i].calcPrice()); 
             
             pwIn.println("==================================================================================");
             pwIn.println("                   THANK YOU FOR CHOOSING SUPER BUS SYSTEM                        ");
             pwIn.println("==================================================================================");
             
             pwIn.close();
            } 
           }
    } // end try
    catch(EOFException eof) //to display a message if an error related to file occur
    {    System.out.println("Problem: "+eof.getMessage());}
    catch(FileNotFoundException e)
    {    System.out.println("Problem: "+e.getMessage());}
    catch(IOException ioe)
    {    System.out.println("Problem: "+ioe.getMessage());}
    finally
    { System.out.println("End of the program"); }
   }
}