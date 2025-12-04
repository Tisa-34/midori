package Generalization;

public class Hotel {
    protected String namaHotel;
    protected String alamat;

    public Hotel(String namaHotel, String alamat) {
        this.namaHotel = namaHotel;
        this.alamat = alamat;
    }

    public void tampilkanInfoHotel() {
        System.out.println("Nama Hotel : " + namaHotel);
        System.out.println("Alamat     : " + alamat);
    }
}
