package pl.fox.lab4;

public class CannotConsumeAirException extends Exception {

    public CannotConsumeAirException() {
        super("I want to consume something that is real :C");
    }
}
