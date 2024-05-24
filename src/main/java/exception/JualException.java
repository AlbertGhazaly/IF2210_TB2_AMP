package exception;

public class JualException extends Exception{
    public JualException() {
        super("Anda tidak dapat melakukan penjualan ! Pastikan slot deck aktif yang dipilih merupakan product !");
    }
}
