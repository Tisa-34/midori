package Association.Bidirectional;

import java.util.*;

public class PetugasDesa {
    private String nama;
    private List<Warga> daftarWarga; 

    public PetugasDesa(String nama) {
        this.nama = nama;
        daftarWarga = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void tambahWarga(Warga warga) {
        daftarWarga.add(warga);
        warga.setPetugas(this); 
    }

    public void tampilkanWarga() {
        System.out.println("Petugas: " + nama + " melayani warga berikut:");
        for (Warga w : daftarWarga) {
            System.out.println("- " + w.getNama());
        }
    }
}
