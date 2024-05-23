package exception;

public class InsertNonItemException extends Exception{
    public InsertNonItemException() {
        super("Cannot insert Non-Item into Not-Null Object !");
    }
}
