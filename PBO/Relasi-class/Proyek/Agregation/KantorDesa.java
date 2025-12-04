package Agregation;

public class KantorDesa {
    private String namaDesa;
    private PetugasDesa[] petugas;

    public KantorDesa(String namaDesa, PetugasDesa[] petugas) {
        this.namaDesa = namaDesa;
        this.petugas = petugas;
    }

    public void tampilkanData() {
        System.out.println("=== Data Kantor Desa ===");
        System.out.println("Nama Desa: " + namaDesa);
        System.out.println("Daftar Petugas Desa:");
        for (PetugasDesa p : petugas) {
            p.tampilkanInfo();
        }
    }
}
