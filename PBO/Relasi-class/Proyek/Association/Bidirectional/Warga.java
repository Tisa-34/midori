package Association.Bidirectional;



public class Warga {
    private String nama;
    private PetugasDesa petugas; 

    public Warga(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setPetugas(PetugasDesa petugas) {
        this.petugas = petugas;
    }

    public PetugasDesa getPetugas() {
        return petugas;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Warga: " + nama);
        if (petugas != null) {
            System.out.println("Dilayani oleh Petugas: " + petugas.getNama());
        }
    }
}

