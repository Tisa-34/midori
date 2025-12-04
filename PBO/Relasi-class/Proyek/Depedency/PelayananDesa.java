package Depedency;

public class PelayananDesa {
    private String namaPelayanan;

    public PelayananDesa(String namaPelayanan) {
        this.namaPelayanan = namaPelayanan;
    }

    public void verifikasiDokumen(Dokumen dokumen) {
        System.out.println("Pelayanan " + namaPelayanan + " sedang memverifikasi dokumen:");
        System.out.println("- Nama Dokumen : " + dokumen.getNamaDokumen());
        System.out.println("- Jenis Dokumen: " + dokumen.getJenis());
        System.out.println("Status: Dokumen terverifikasi ✅");
    }
}
