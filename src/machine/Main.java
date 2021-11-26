package machine;

import java.util.Scanner;

import machine.entity.Coin;
import machine.entity.CoinBundle;
import machine.service.VendingMachine;
import machine.service.impl.VendingMachineImpl;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
		String choice = null;
        String userEnteredCoins = null;
        CoinBundle cc = null;

        VendingMachine machineInterface = new VendingMachineImpl();

        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        machineInterface.selectProduct(Integer.parseInt(selectedProduct));
        
		do {
	        machineInterface.displayEnterCoinsMessage();
	        userEnteredCoins = scanner.nextLine();
	        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
	        cc = machineInterface.enterCoins(enteredCoins);
	        if (cc.getTotal() < 0) {
				System.out.println(" Your amount is not enough!!! please re-enter.");
	        }
		} while (cc.getTotal() < 0);

        machineInterface.displayChangeMessage();

    }
}
