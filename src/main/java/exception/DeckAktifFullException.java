package exception;

public class DeckAktifFullException extends Exception{
    public DeckAktifFullException() {
        super("Deck Aktif Space Not Enough !");
    }
}
