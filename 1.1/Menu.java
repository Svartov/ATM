package ATM;

import java.util.*;

public class Menu {

    protected static void menu(int numberD, double sum, Functional functional) {
        Scanner in = new Scanner(System.in);
        Check check = new Check();
        for (; ; ) {
            System.out.println("1 - Check balance");
            System.out.println("2 - Top up balance");
            System.out.println("3 - Withdraw money from balance");
            System.out.println("4 - Log off");
            System.out.print("What do you want to do?: ");
            numberD = in.nextInt();

            switch (numberD) {
                case (1):
                    functional.checkBalanc();
                    check.printCheckBalanc(functional);
                    break;
                case (2):
                    System.out.print("Enter sum:");
                    sum = in.nextDouble();
                    functional.addBalanc(sum);
                    check.printCheckBalanc(functional);
                    break;
                case (3):
                    System.out.print("Enter sum:");
                    sum = in.nextDouble();
                    functional.withdrawCash(sum);
                    check.printCheckBalanc(functional);
                    break;
                case (4):
                    System.out.println("See you!");
                    System.exit(1);
                default:
                    System.out.println("Wrong number selected");
            }
            System.out.println();
        }
    }
}


