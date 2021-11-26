package machine.service.impl;

import machine.entity.Coin;
import machine.entity.CoinBundle;
import machine.entity.MachineRequest;
import machine.service.Calculator;

public class CalculatorImpl implements Calculator{

    @Override
    public int calculateTotal(CoinBundle enteredCoins) {
        return enteredCoins.getTotal();
    }

    @Override
    public CoinBundle calculateChange(int amountMoneyToReturn) {
        CoinBundle change = new CoinBundle(new int[5]);
        int remainingAmount = amountMoneyToReturn;
        change.number200k = remainingAmount / Coin.TWO_HUNDRED.getValue();
        remainingAmount = remainingAmount % Coin.TWO_HUNDRED.getValue();

        change.number100k = remainingAmount / Coin.HUNDRED.getValue();
        remainingAmount = remainingAmount % Coin.HUNDRED.getValue();

        change.number50k = remainingAmount / Coin.FIFTY.getValue();
        remainingAmount = remainingAmount % Coin.FIFTY.getValue();

        change.number20k = remainingAmount / Coin.TWENTY.getValue();
        remainingAmount = remainingAmount % Coin.TWENTY.getValue();

        change.number10k = remainingAmount / Coin.TEN.getValue();


        return change;
    }
    
    @Override
    public CoinBundle calculateChange(MachineRequest request) {
        int total = this.calculateTotal(request.enteredCoins);
        int totalChange = total - request.product.getPrice();
        return this.calculateChange(totalChange);
    }
}
