package exception;

public class SelectShuffleCardOverException extends Exception{
    public SelectShuffleCardOverException(){
        super("Jumlah kartu yang kamu pilih itu kebanyakan...");
    }
}
