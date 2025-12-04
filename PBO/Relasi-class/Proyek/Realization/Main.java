package Realization;

public class Main {
    public static void main(String[] args) {
        PelayananMasyarakat layananKTP = new PelayananKTP();
        PelayananMasyarakat layananKK = new PelayananKK();

        System.out.println("=== Pelayanan Masyarakat Desa A ===\n");

        layananKTP.prosesPermohonan("Wiliam James Moriarty");
        layananKTP.cetakDokumen("Wiliam James Moriarty");

        System.out.println();

        layananKK.prosesPermohonan("Sherlock Holmes");
        layananKK.cetakDokumen("Sherlock Holmes");
    }
}

