package Ocp;

public class Debit implements TipePembayaran {
    @Override
    public void memprosesPembayaran() {
        System.out.println("Memproses pembayaran menggunakan kartu Debit...");
    }
}
