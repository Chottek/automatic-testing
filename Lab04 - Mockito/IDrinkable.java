package pl.fox.lab4;

public interface IDrinkable {

    int getAmount();
    boolean isEmpty();
    void drink(int howMuch) throws CannotConsumeAirException;
}
