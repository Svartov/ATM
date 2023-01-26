package ATM;

import java.util.*;

public class Functional extends Card {
    Scanner in = new Scanner(System.in);

    private List<Integer> cash = new ArrayList<>();
    private List<Integer> coins = new ArrayList<>();
    private int examinationPinCod;
    private int sumEdit;


    protected void setExaminationPinCod(int examinationPinCod) { // PIN code check
        this.examinationPinCod = examinationPinCod;
    }

    protected int setSumEdit(int sumEdit) {
        this.sumEdit = sumEdit;
        return sumEdit;
    }

    protected int sumCoins(){
        int sum = coins.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    protected int sumCashInAtm(){
        int sum = cash.stream().mapToInt(Integer::intValue).sum();
        return sum;
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
        System.out.println( "\n" + "Hei " + getNAME_CARD() + " " + getSURNAME_CARD() + " your balance = " + getBalanc() + " NOK");
    }

    protected void addBalanc(int enterSum){ // Top up balance
        if(enterSum < 50000 || enterSum == 50000) {
            if(!(sumCashInAtm() + enterSum > 500000)) {
                if (enterSum > 0) {
                    setBalanc(setSumEdit(getBalanc() + enterSum));
                    cash.add(enterSum);
                    System.out.println("\n" + "Balance = " + getBalanc() + " NOK");
                } else {
                    System.out.println("\n" + "Error! The amount must be greater than 0!");
                }
            }else {
                System.out.println("There are not enough funds in the ATM!");
            }
        }else {
            System.out.println("\n" + "You cannot deposit more than 50000 NOK");
        }
    }

    protected void withdrawCash(int enterSum){ // Withdraw money from balance
        sumEdit = getBalanc() - enterSum;
        if(getBalanc() > enterSum && getBalanc() > 0 && enterSum > 0 && getBalanc() > 0 && sumCashInAtm() > 0 && sumCashInAtm() > enterSum){
            setBalanc(sumEdit);
            int n = 0;
            for(int i = 0; i < 2; i++){
                 n += cash.get(cash.size() - 1);
                 cash.remove(cash.size() - 1);
            }
            if(n < enterSum){
                n += cash.get(cash.size() - 1);
                cash.remove(cash.size() - 1);
            }else if(n > enterSum){
                n = n - enterSum;
                cash.add(n);
            }else if(n == enterSum){
                n = n - enterSum;
            }
            System.out.println("\n" + "Balance = " +getBalanc() + " NOK");
        }else {
            System.out.println("\n" + "Error! Balance less than this amount!");
        }
    }

    protected void depositCoin(int enterSum){
        if(enterSum == 1 ||enterSum == 5 || enterSum == 10 || enterSum == 20){
            coins.add(enterSum);
        }else {
            System.out.println("Coin not recognized (Denomination 1/5/10/20)");
        }
    }

    protected void coinTransfer(){
        setBalanc(getBalanc() + sumCoins());
        System.out.println("\n" + "Balance = " + getBalanc() + " NOK");
    }

    protected void setCashAtm(){
        /**
         * NOK have 50-100-200-500-1000 cash value
         * NOK have 1-5-10-20 coins value
         * In this section, we fill only the cache
         */
        for(int i = 0; i < 150; i++){
            if(i < 10) {
                cash.add(50);
            }else if(i > 10 && i < 30){
                cash.add(100);
            }else if(i > 40 && i < 50){
                cash.add(200);
            }else if(i > 50 && i < 60){
                cash.add(500);
            }else if(i > 60){
                cash.add(1000);
            }
        }
    }


}
