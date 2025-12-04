package Composition;

public class Main {
    public static void main(String[] args) {
        KantorDesa kantor = new KantorDesa("Desa Konoha", "001/DESA/2025", "Surat Keterangan Domisili");
        kantor.tampilkanInfo();

        
        kantor = null;
        System.out.println("\nKantorDesa telah dihapus, arsip surat juga tidak dapat diakses lagi.");
    }
}
