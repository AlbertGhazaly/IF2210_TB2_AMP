package exception;

public class InappropriateObjectInsertion extends Exception{
    public InappropriateObjectInsertion(){
        super("Object insertion failed, inappropriate object type");
    }
}
