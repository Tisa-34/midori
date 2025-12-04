package Agregation;


public class PetugasDesa {
    private String nama;
    private String jabatan;

    public PetugasDesa(String nama, String jabatan) {
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Petugas: " + nama + " | Jabatan: " + jabatan);
    }
}
