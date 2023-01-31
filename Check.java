package ATM;

import java.text.*;
import java.util.*;
import java.io.*;

public class Check{
    Scanner in = new Scanner(System.in);

     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Create a form for the date
     Date date = new Date(); // Create date object
     File check = new File("check.txt"); // Specify in which file we will output the receipt

     protected void printCheckBalanc(Functional functional){
        try(PrintWriter pw = new PrintWriter(check)){
            pw.println("Name: " + functional.getNAME_CARD() + " " + "Surname: " + functional.getSURNAME_CARD()
                    + "" + "Account number: " + functional.getACCOUNT_NUMBER()); // Specify the user's personal data
            pw.println("Balance: " + functional.getBalanc() + " NOK"); // Specify the balance
            pw.println("Date: " + sdf.format(date)); // Specify the date
        }catch (IOException e){
            e.printStackTrace();
        }
     }

}
