package Generalization;

public class PegawaiDesa {
    protected String nama;
    protected String jabatan;

    public PegawaiDesa(String nama, String jabatan) {
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public void tampilkanData() {
        System.out.println("Nama     : " + nama);
        System.out.println("Jabatan  : " + jabatan);
    }

    public void bekerja() {
        System.out.println(jabatan + " sedang melaksanakan tugas umum di kantor desa.");
    }
}
