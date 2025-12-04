package Composition;

public class Hotel {
    private String namaHotel;
    private Kamar kamar;

    public Hotel(String namaHotel, String nomorKamar, String tipeKamar) {
        this.namaHotel = namaHotel;
        this.kamar = new Kamar(nomorKamar, tipeKamar);
    }

    public void tampilkanInfo() {
        System.out.println("Nama Hotel: " + namaHotel);
        kamar.tampilkanInfoKamar();
    }
}
