package Association.Bidirectional;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String namaHotel;
    private List<Tamu> daftarTamu;

    public Hotel(String namaHotel) {
        this.namaHotel = namaHotel;
        this.daftarTamu = new ArrayList<>();
    }

    public void tambahTamu(Tamu tamu) {
        daftarTamu.add(tamu);
        tamu.setHotel(this); 
    }

    public void tampilkanTamu() {
        System.out.println("Daftar tamu di " + namaHotel + ":");
        for (Tamu t : daftarTamu) {
            System.out.println("- " + t.getNamaTamu());
        }
    }

    public String getNamaHotel() {
        return namaHotel;
    }
}
