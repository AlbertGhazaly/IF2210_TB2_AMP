package exception;

public class SelectShuffleCardLessException extends Exception{
    public SelectShuffleCardLessException(){
        super("Jumlah kartu yang kamu pilih itu kedikitan...");
    }
}
