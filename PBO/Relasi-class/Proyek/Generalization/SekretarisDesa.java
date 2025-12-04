package Generalization;

public class SekretarisDesa extends PegawaiDesa {

    public SekretarisDesa(String nama) {
        super(nama, "Sekretaris Desa");
    }

    @Override
    public void bekerja() {
        System.out.println("Sekretaris Desa " + nama + " sedang mengelola arsip dan menyusun laporan administrasi.");
    }
}
