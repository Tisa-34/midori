package Association.Unidirectional;

public class Main {
    public static void main(String[] args) {
        KantorDesa kantor = new KantorDesa("Desa Konoha", "Jl. Pahlawan No. 10");
        PetugasDesa petugas = new PetugasDesa("Kudo Shinichi", kantor);

        System.out.println("=== Data Petugas Desa ===");
        petugas.tampilkanInfo();

        
    }
}
