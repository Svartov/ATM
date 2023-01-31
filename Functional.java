package ATM;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

public class Functional extends Card {
    Scanner in = new Scanner(System.in);

    private List<Integer> coins = new ArrayList<>();
    private List<Integer> cashFifty = new ArrayList<>(); // Array for 50 NOK
    private List<Integer> cashOneHundred  = new ArrayList<>();// Array for 100 NOK
    private List<Integer> cashTwoHundred = new ArrayList<>(); // Array for 200 NOK
    private List<Integer> cashFiveHundred= new ArrayList<>(); // Array for 500 NOK
    private List<Integer> cashThousand = new ArrayList<>(); // Array for 1000 NOK
    private List<Integer> withdrawals = new ArrayList<>(); // Array for 1000 NOK

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
        return coins.stream().mapToInt(Integer::intValue).sum();
    }

    protected int sumCashInAtm(){
         int sum  = cashFifty.stream().mapToInt(Integer::intValue).sum();
         sum += cashOneHundred.stream().mapToInt(Integer::intValue).sum();
         sum += cashThousand.stream().mapToInt(Integer::intValue).sum();
         sum += cashFiveHundred.stream().mapToInt(Integer::intValue).sum();
         sum += cashThousand.stream().mapToInt(Integer::intValue).sum();
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
        int sum = 0;
        int numberCash = 0;
        if(enterSum < 50000 || enterSum == 50000) {
            if(!(sumCashInAtm() + enterSum > 500000)) {
                int remainder = enterSum % 50;
                if(enterSum >= 50 && remainder == 0){
                        for (; ; ) {
                            System.out.print("Deposit a banknote: ");
                            numberCash = in.nextInt();
                            if (numberCash == 50 || numberCash == 100 || numberCash == 200 || numberCash == 500 || numberCash == 1000) {
                                if (sum + numberCash < enterSum || sum + numberCash != enterSum) {
                                    switch (numberCash) {
                                        case 50:
                                            cashFifty.add(numberCash);
                                            sum += numberCash;
                                            numberCash = 0;
                                            break;
                                        case 100:
                                            cashOneHundred.add(numberCash);
                                            sum += numberCash;
                                            numberCash = 0;
                                            break;
                                        case 200:
                                            cashTwoHundred.add(numberCash);
                                            sum += numberCash;
                                            numberCash = 0;
                                            break;
                                        case 500:
                                            cashFiveHundred.add(numberCash);
                                            sum += numberCash;
                                            numberCash = 0;
                                            break;
                                        case 1000:
                                            cashThousand.add(numberCash);
                                            sum += numberCash;
                                            numberCash = 0;
                                            break;
                                        default:
                                            System.out.println("Error");
                                            break;
                                    }
                                    System.out.println("It remains to contribute: " + (enterSum - sum));
                                } else {
                                    setBalanc(setSumEdit(getBalanc() + enterSum));
                                    System.out.println("\n" + "Balance = " + getBalanc() + " NOK");
                                    break;
                                }
                            } else {
                                System.out.println("\n" + "Banknote not recognized");
                            }
                        }
                }else{
                    System.out.println("\n" + "Sorry, it's not correct!");
                }
            }else {
                System.out.println("\n" + "There are not enough funds in the ATM!");
            }
        }else {
            System.out.println("\n" + "You cannot deposit more than 50000 NOK");
        }
    }

    protected void withdrawCash(int enterSum){ // Withdraw money from balance
        int sum = 0;
        int thisSum = enterSum;
        sumEdit = getBalanc() - enterSum;
        int remainder = enterSum % 50;
        if(enterSum >= 50 && remainder == 0){
            if(getBalanc() >= enterSum && getBalanc() >= 0 && sumCashInAtm() > 0 && sumCashInAtm() >= enterSum) {
                for (; ; ) {
                    if (thisSum != 0) {
                        if (thisSum >= 1000) {
                            sum += cashThousand.get(1);
                            withdrawals.add(cashThousand.get(1));
                            cashThousand.remove(1);
                            thisSum = thisSum - 1000;
                        } else if (thisSum >= 500) {
                            sum += cashFiveHundred.get(1);
                            withdrawals.add(cashFiveHundred.get(1));
                            cashFiveHundred.remove(1);
                            thisSum = thisSum - 500;
                        } else if (thisSum >= 200) {
                            sum += cashTwoHundred.get(1);
                            withdrawals.add(cashTwoHundred.get(1));
                            cashTwoHundred.remove(1);
                            thisSum = thisSum - 200;
                        } else if (thisSum >= 100) {
                            sum += cashOneHundred.get(1);
                            withdrawals.add(cashOneHundred.get(1));
                            cashOneHundred.remove(1);
                            thisSum = thisSum - 100;
                        } else if (thisSum >= 50) {
                            sum += cashFifty.get(1);
                            withdrawals.add(cashFifty.get(1));
                            cashFifty.remove(1);
                            thisSum = thisSum - 50;
                        }
                    } else if (thisSum == 0) {
                        setBalanc(sumEdit);
                        withdrawals.removeAll(withdrawals);
                        System.out.println("\n" + "Balance = " + getBalanc() + " NOK");
                        break;
                    }
                }
            }else {
                System.out.println("\n" + "Error! Balance less than this amount!");
            }
        }else {
            System.out.println("\n" + "Unfortunately, this amount cannot be withdrawn!");
        }
    }

    protected void depositCoin(int enterSum){
        if(enterSum == 1 ||enterSum == 5 || enterSum == 10 || enterSum == 20){
            coins.add(enterSum);
        }else {
            System.out.println("\n" + "Coin not recognized (Denomination 1/5/10/20)");
        }
    }

    protected void coinTransfer(){
        setBalanc(getBalanc() + sumCoins());
        coins.removeAll(coins);
        System.out.println("\n" + "Balance = " + getBalanc() + " NOK");
    }

    protected void setCashAtm(){
        /**
         * NOK have 50-100-200-500-1000 cash value
         * NOK have 1-5-10-20 coins value
         * In this section, we fill only the cache
         */
        for(int i = 0; i < 100; i++){
            cashFifty.add(50);
            cashOneHundred.add(100);
            cashTwoHundred.add(200);
            cashFiveHundred.add(500);
            cashThousand.add(1000);
        }
    }
}