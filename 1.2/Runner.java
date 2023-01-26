package ATM;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Functional functional = new Functional(); // Create a functional object
        int pinCode = 0;

        System.out.print("Enter your PinCode: "); // PIN code check
        functional.setExaminationPinCod(pinCode = in.nextInt());
        if (!(functional.checkPinCode())) {
            System.exit(404);
        }
        Menu.menu(functional); // Calling the user menu
    }
}
