package machine.entity;

public class MachineRequest {
    public Product product;
    public CoinBundle enteredCoins;

    public MachineRequest(int selectedProduct,int... enteredCoins){
        this.product = Product.valueOf(selectedProduct);
        this.enteredCoins = new CoinBundle(enteredCoins);
    }
}
