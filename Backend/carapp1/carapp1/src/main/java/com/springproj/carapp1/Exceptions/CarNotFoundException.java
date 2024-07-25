package Exceptions;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String msg){
        super(msg);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
