package Depedency;

public class Main {
    public static void main(String[] args) {
        Dokumen dokumen = new Dokumen("Surat Keterangan Tidak Mampu", "SKTM");

        PelayananDesa pelayanan = new PelayananDesa("Pelayanan Sosial");
        pelayanan.verifikasiDokumen(dokumen);

        System.out.println("\nHubungan Dependency selesai — PelayananDesa tidak menyimpan dokumen.");
    }
}

