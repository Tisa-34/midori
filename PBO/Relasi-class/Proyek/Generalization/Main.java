package Generalization;

public class Main {
    public static void main(String[] args) {
        PegawaiDesa pegawai1 = new KepalaDesa("Kudo Shinichi");
        PegawaiDesa pegawai2 = new SekretarisDesa("Hattori Heiji");

        System.out.println("=== Data Pegawai Desa ===");
        pegawai1.tampilkanData();
        pegawai1.bekerja();

        System.out.println();
        pegawai2.tampilkanData();
        pegawai2.bekerja();
    }
}
