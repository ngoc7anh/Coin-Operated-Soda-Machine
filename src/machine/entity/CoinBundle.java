package machine.entity;

public class CoinBundle {
    public int number10k;
    public int number20k;
    public int number50k;
    public int number100k;
    public int number200k;

    public CoinBundle(int... enteredCoins) {
        this.number10k = enteredCoins[0];
        this.number20k = enteredCoins[1];
        this.number50k = enteredCoins[2];
        this.number100k = enteredCoins[3];
        this.number200k = enteredCoins[4];

    }


    public int getTotal(){
        int total = 0;
        total = total+this.number10k*Coin.TEN.getValue();
        total = total+this.number20k*Coin.TWENTY.getValue();
        total = total+this.number50k*Coin.FIFTY.getValue();
        total = total+this.number100k*Coin.HUNDRED.getValue();
        total = total+this.number200k*Coin.TWO_HUNDRED.getValue();
        return total;
    }
}
