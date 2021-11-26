package machine.service.impl;

import machine.entity.CoinBundle;
import machine.entity.Product;
import machine.entity.VendingMachineRequest;
import machine.service.Calculator;
import machine.service.VendingMachine;

public class VendingMachineImpl implements VendingMachine {

    private Calculator calculator = new CalculatorImpl();
    private int selectedProduct;
    private CoinBundle change;


    @Override
    public void displayProducts() {
        System.out.println("      Products available:               ");
        System.out.println("                                              ");
        for(Product product: Product.values()){
            if(!Product.EMPTY.equals(product)) {
                System.out.println("     " + product.getSelectionNumber() + ":  " + product.name() + " - Price: " + product.getPrice() + "   ");
            }
        }
        System.out.println("                                              ");
        System.out.print("    Please select your product: ");


    }

    @Override
    public void selectProduct(int product) {
        this.selectedProduct = product;
    }

    @Override
    public void displayEnterCoinsMessage() {
    	System.out.println("");
        System.out.println(" Please enter coins as follows: ");
        System.out.println(" Number of 10.000 VND, number of 20.000 VND, number of 50.000 VND, number of 100.000 VND, number of 200.000 VND");
        System.out.println(" Example: If you would like to enter 2 coins 50.000 VND: 0,0,2,0,0");
        System.out.print("   Plese enter coins:");

    }

    @Override
    public CoinBundle enterCoins(int... coins) {
        VendingMachineRequest request = new VendingMachineRequest(selectedProduct, coins);
        change = calculator.calculateChange(request);
        return change;

    }

    @Override
    public void displayChangeMessage() {
        System.out.println("");
        System.out.println("Your refund is :"+ change.getTotal()+" VND split as follows: ");
        System.out.println("    200.000 VND: "+ change.number200k);
        System.out.println("    100.000 VND: "+ change.number100k);
        System.out.println("    50.000 VND: "+ change.number50k);
        System.out.println("    20.000 VND: "+ change.number20k);
        System.out.println("    10.000 VND: "+ change.number10k);

    }
}
