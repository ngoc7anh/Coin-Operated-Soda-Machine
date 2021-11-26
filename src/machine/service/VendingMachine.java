package machine.service;

import machine.entity.CoinBundle;

public interface VendingMachine {

    void displayProducts();

    void selectProduct(int product);

    void displayEnterCoinsMessage();

    CoinBundle enterCoins(int... coins);

    void displayChangeMessage();
}
