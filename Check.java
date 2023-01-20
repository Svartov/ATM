package ATM;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Check{
    Scanner in = new Scanner(System.in);

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    static Date date = new Date();
    static Functional functional = new Functional();
    static File check = new File("check.txt");

    public static void printCheckBalanc(){

        try(PrintWriter pw = new PrintWriter(check)){
            pw.println("Check #1 - " + functional.getNAME_CARD() + " " + functional.getSURNAME_CARD());
            pw.println(functional.getBalanc());
            pw.println(sdf.format(date));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
