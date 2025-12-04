package Association.Unidirectional;

public class Hotel {
    private String namaHotel;
    private String alamat;

    public Hotel(String namaHotel, String alamat) {
        this.namaHotel = namaHotel;
        this.alamat = alamat;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Hotel : " + namaHotel);
        System.out.println("Alamat     : " + alamat);
    }
}

