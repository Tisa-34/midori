package Aggregation;

public class Hotel {
    private String namaHotel;
    private Kamar[] daftarKamar;

    public Hotel(String namaHotel, Kamar[] daftarKamar) {
        this.namaHotel = namaHotel;
        this.daftarKamar = daftarKamar;
    }

    public void tampilkanInfoHotel() {
        System.out.println("Nama Hotel: " + namaHotel);
        System.out.println("Daftar Kamar yang Tersedia:");
        for (Kamar k : daftarKamar) {
            k.tampilkanInfoKamar();
        }
    }
}

