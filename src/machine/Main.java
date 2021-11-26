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
        CoinBundle cb = null;

        VendingMachine machine = new VendingMachineImpl();

        machine.displayProducts();

        String selectedProduct = scanner.nextLine();
        machine.selectProduct(Integer.parseInt(selectedProduct));
        
		do {
			machine.displayEnterCoinsMessage();
	        userEnteredCoins = scanner.nextLine();
	        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
	        cb = machine.enterCoins(enteredCoins);
	        if (cb.getTotal() < 0) {
				System.out.println(" Your amount is not enough! Please re-enter.");
	        }
		} while (cb.getTotal() < 0);

		machine.displayChangeMessage();

    }
}
