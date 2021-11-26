package machine.service;

import machine.entity.CoinBundle;
import machine.entity.VendingMachineRequest;

public interface Calculator {
    int calculateTotal(CoinBundle enteredCoins);
    CoinBundle calculateChange(int enteredByUserMoney);
	CoinBundle calculateChange(VendingMachineRequest request);
}
