package pl.fox.lab4;

public class Beer extends Food implements IDrinkable {

    private int amount;

    public Beer(String name, int initialAmount) {
        super(name);
        this.amount = initialAmount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    @Override
    public void drink(int howMuch) throws CannotConsumeAirException {
        if(amount - howMuch < 0){
            amount = 0;
            throw new CannotConsumeAirException();
        }
        amount -= howMuch;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name=" + getName() +
                "amount=" + amount +
                '}';
    }
}
