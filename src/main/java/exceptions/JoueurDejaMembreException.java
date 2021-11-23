package exceptions;

public class JoueurDejaMembreException extends Exception {
	// Parameterless Constructor
    public JoueurDejaMembreException() {}

    // Constructor that accepts a message
    public JoueurDejaMembreException(String message){
       super(message);
    }
}