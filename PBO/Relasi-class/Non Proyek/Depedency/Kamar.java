package Depedency;

public class Kamar {
    private int nomorKamar;
    private double harga;

    public Kamar(int nomorKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.harga = harga;
    }

    public void tampilkanInfoKamar() {
        System.out.println("Kamar Nomor: " + nomorKamar + " | Harga: Rp" + harga);
    }

    public double getHarga() {
        return harga;
    }
}
