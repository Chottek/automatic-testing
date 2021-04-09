package pl.fox.lab4;

public interface IEdible {

    int getQuantity();
    void eat(int howMany) throws CannotConsumeAirException;

}
