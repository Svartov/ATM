package ATM;

import java.util.Scanner;

public class Functional extends Card {
    Scanner in = new Scanner(System.in);

    private int examinationPinCod; // Проверка на пинкод
    private double sumEdit;

    protected void setExaminationPinCod(int examinationPinCod) { // Проверка на пинкод
        this.examinationPinCod = examinationPinCod;
    }

    protected double setSumEdit(double sumEdit) {
        this.sumEdit = sumEdit;
        return sumEdit;
    }

    protected double getSumEdit() {
        return sumEdit;
    }

    protected boolean checkPinCode(){ // Проверка на пинкод
        if(examinationPinCod == getPIN_CODE()){
           System.out.println("Complete\n" + "ACCOUNT NUMBER: " + getACCOUNT_NUMBER() + "\n");
           return true;
        }else{
            System.out.println("Error\n");
            return false;
        }
    }

    protected void checkBalanc(){  // Проврка баланса
        System.out.println( "\n" + "Hei " + getNAME_CARD() + " " + getSURNAME_CARD() + " your balanc = " + getBalanc() + "EUR");
        Check.printCheckBalanc();
    }

    protected void addBalanc(double enterSum){ // Добавить средства
        if (enterSum > 0) {
            setBalanc(setSumEdit(getBalanc() + enterSum));
            System.out.println("\n" + "Balanc = " + getBalanc() + "EUR");
            Check.printCheckBalanc();
        }else {
            System.out.println("Error! The amount must be greater than 0!");
        }
    }

    protected void withdrawCash(double enterSum){ // снят средства
        sumEdit = getBalanc() - enterSum;
        if(getBalanc() > enterSum && getBalanc() > 0 && enterSum > 0){
            setBalanc(sumEdit);
            System.out.println("\n" + "Balanc = " +getBalanc() + "EUR");
            Check.printCheckBalanc();
        }else {
            System.out.println("Error! Balance less than this amount!");
        }
    }

    public  void menu(int numberD, double sum, Functional functional) {
        Scanner in = new Scanner(System.in);
        for (; ; ) {
            System.out.println("1- Проверить баланс");
            System.out.println("2- Пополнить баланс");
            System.out.println("3- Снять деньги с баланса");
            System.out.println("4- Выйти");
            System.out.print("Что вы хотите сделать?: ");
            numberD = in.nextInt();

            switch (numberD) {
                case (1):
                    functional.checkBalanc();
                    break;
                case (2):
                    System.out.print("Enter sum:");
                    sum = in.nextDouble();
                    functional.addBalanc(sum);
                    break;
                case (3):
                    System.out.print("Enter sum:");
                    sum = in.nextDouble();
                    functional.withdrawCash(sum);
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
