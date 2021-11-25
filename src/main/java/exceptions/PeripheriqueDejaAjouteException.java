package exceptions;

public class PeripheriqueDejaAjouteException extends Exception {
	// Parameterless Constructor
    public PeripheriqueDejaAjouteException() {}

    // Constructor that accepts a message
    public PeripheriqueDejaAjouteException(String message){
       super(message);
    }
}