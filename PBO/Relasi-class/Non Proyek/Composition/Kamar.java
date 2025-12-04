package Composition;

public class Kamar {
    private String nomorKamar;
    private String tipeKamar;

    public Kamar(String nomorKamar, String tipeKamar) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
    }

    public void tampilkanInfoKamar() {
        System.out.println("Nomor Kamar: " + nomorKamar);
        System.out.println("Tipe Kamar : " + tipeKamar);
    }
}

