package Composition;

public class KantorDesa {
    private String namaDesa;
    private ArsipSurat arsip; 

    public KantorDesa(String namaDesa, String nomorSurat, String jenisSurat) {
        this.namaDesa = namaDesa;
        this.arsip = new ArsipSurat(nomorSurat, jenisSurat);
    }

    public void tampilkanInfo() {
        System.out.println("=== Data Kantor Desa ===");
        System.out.println("Nama Desa: " + namaDesa);
        System.out.println("--- Arsip Surat ---");
        arsip.tampilkanArsip();
    }
}
