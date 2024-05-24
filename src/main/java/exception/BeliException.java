package exception;

public class BeliException extends Exception{
    public BeliException() {
        super("Anda tidak dapat melakukan pembelian ! Pastikan slot deck aktif kosong, gulden anda cukup, dan stok tersedia pada toko !");
    }
}
