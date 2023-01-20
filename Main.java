package ATM;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Functional functional = new Functional();
        int numberD = 0;
        double sum = 0;
        int pinCode = 0;

        System.out.print("Enter your PinCode: ");
        functional.setExaminationPinCod(pinCode = in.nextInt());

        if(!(functional.checkPinCode())){
            System.exit(404);
        }

        functional.menu(numberD,sum,functional);
    }
}


