package pl.fox.lab4;

public class Sandwich extends Food implements IEdible{

    private int quantity;

    public Sandwich(String name, int initialQuantity) {
        super(name);
        this.quantity = initialQuantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void eat(int howMany) throws CannotConsumeAirException {
        if(quantity - howMany < 0){
            quantity = 0;
            throw new CannotConsumeAirException();
        }
        quantity -= howMany;
    }


}
