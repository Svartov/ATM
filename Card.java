package ATM;

public abstract class Card {
    private  final long ACCOUNT_NUMBER = 444108673;
    private  final int PIN_CODE = 9406;
    private  final String NAME_CARD = "Anton";
    private  final String SURNAME_CARD = "Voloxin";

    private int balanc = 10000;

    protected long getACCOUNT_NUMBER() {
        return ACCOUNT_NUMBER;
    }

    protected  int getPIN_CODE() {
        return PIN_CODE;
    }

    protected  String getNAME_CARD() {
        return NAME_CARD;
    }

    protected  String getSURNAME_CARD() {
        return SURNAME_CARD;
    }

    protected  int getBalanc() {
        return balanc;
    }

    protected  void setBalanc(int balanc) {
        this.balanc = balanc;
    }

    @Override
    public  String toString() {
        return "Card{" + "ACCOUNT_NUMBER=" + ACCOUNT_NUMBER + ", PIN_CODE=" + PIN_CODE + ", NAME_CARD='" + NAME_CARD + '\'' + ", SURNAME_CARD='" + SURNAME_CARD + '\'' + ", blanc=" + balanc + '}';
    }
}
