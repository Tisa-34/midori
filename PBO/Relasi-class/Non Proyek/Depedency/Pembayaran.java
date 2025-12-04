package Depedency;

public class Pembayaran {
    private String metode;

    public Pembayaran(String metode) {
        this.metode = metode;
    }

    public void prosesPembayaran(double jumlah) {
        System.out.println("Pembayaran sebesar Rp" + jumlah + " menggunakan metode " + metode + " berhasil dilakukan!");
    }
}
