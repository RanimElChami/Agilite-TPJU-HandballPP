package exceptions;

public class JoueurNonMembreException extends Exception {
	// Parameterless Constructor
    public JoueurNonMembreException() {}

    // Constructor that accepts a message
    public JoueurNonMembreException(String message){
       super(message);
    }
}