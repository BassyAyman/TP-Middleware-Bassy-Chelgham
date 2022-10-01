package exception;

/**
 * @author : Zinedine Chelgham
 **/

public class SignInFailedException extends Exception{

    public SignInFailedException(String message) {
        super(message);
    }
}
