package ATM;

import java.util.Scanner;

public class Functional extends Card {
    Scanner in = new Scanner(System.in);


    private int examinationPinCod; //  PIN code check
    private double sumEdit;

    protected void setExaminationPinCod(int examinationPinCod) { // PIN code check
        this.examinationPinCod = examinationPinCod;
    }

    protected double setSumEdit(double sumEdit) {
        this.sumEdit = sumEdit;
        return sumEdit;
    }

    protected double getSumEdit() {
        return sumEdit;
    }

    protected boolean checkPinCode(){ // PIN code check
        if(examinationPinCod == getPIN_CODE()){
           System.out.println("Complete\n" + "ACCOUNT NUMBER: " + getACCOUNT_NUMBER() + "\n");
           return true;
        }else{
            System.out.println("Error\n");
            return false;
        }
    }

    protected void checkBalanc(){  // Balance check
        System.out.println( "\n" + "Hei " + getNAME_CARD() + " " + getSURNAME_CARD() + " your balance = " + getBalanc() + "EUR");
    }

    protected void addBalanc(double enterSum){ // Top up balance
        if (enterSum > 0) {
            setBalanc(setSumEdit(getBalanc() + enterSum));
            System.out.println("\n" + "Balance = " + getBalanc() + "EUR");
        }else {
            System.out.println("Error! The amount must be greater than 0!");
        }
    }

    protected void withdrawCash(double enterSum){ // Withdraw money from balance
        sumEdit = getBalanc() - enterSum;
        if(getBalanc() > enterSum && getBalanc() > 0 && enterSum > 0){
            setBalanc(sumEdit);
            System.out.println("\n" + "Balance = " +getBalanc() + "EUR");
        }else {
            System.out.println("Error! Balance less than this amount!");
        }
    }
}
