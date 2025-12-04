package Ocp;

public class Kredit implements TipePembayaran {
    @Override
    public void memprosesPembayaran() {
        System.out.println("Memproses pembayaran menggunakan kartu Kredit...");
    }
}
