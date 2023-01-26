package ATM;

import java.util.*;

public class Menu {

    protected static void menu(Functional functional) {
        Scanner in = new Scanner(System.in);
        Check check = new Check();
        functional.setCashAtm();


        int numberD = 0;
        int sum = 0;
        for (; ; ) {
            System.out.println("1 - Check balance");
            System.out.println("2 - Top up balance");
            System.out.println("3 - Withdraw money from balance");
            System.out.println("4 - Put coins on the card");
            System.out.println("5 - Log off");
            System.out.print("What do you want to do?: ");
            numberD = in.nextInt();

            switch (numberD) {
                case (1):
                    functional.checkBalanc();
                    check.printCheckBalanc(functional);
                    break;
                case (2):
                    System.out.print("Enter sum:");
                    sum = in.nextInt();
                    functional.addBalanc(sum);
                    check.printCheckBalanc(functional);
                    break;
                case (3):
                    System.out.print("Enter sum:");
                    sum = in.nextInt();
                    functional.withdrawCash(sum);
                    check.printCheckBalanc(functional);
                    break;
                case (4):
                    System.out.print("Enter sum: ");
                    sum = in.nextInt();
                    functional.depositCoin(sum);

                    for (;;){
                        System.out.println("1 -Contribute more");
                        System.out.println("2 - Log off");
                        System.out.print("What do you want to do?: ");
                        numberD = in.nextInt();
                        if(numberD == 1) {
                            System.out.print("Enter sum: ");
                            sum = in.nextInt();
                            functional.depositCoin(sum);
                        }else if (numberD == 2){
                            functional.coinTransfer();
                            check.printCheckBalanc(functional);
                            break;
                        }
                    }
                    break;
                case (5):
                    System.out.println("See you!");
                    System.exit(1);
                default:
                    System.out.println("Wrong number selected");
            }
            System.out.println();
        }
    }
}


