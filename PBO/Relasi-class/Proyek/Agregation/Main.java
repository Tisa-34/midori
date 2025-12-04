package Agregation;

public class Main {
    public static void main(String[] args) {
        
        PetugasDesa p1 = new PetugasDesa("Kudo Shinichi", "Staf Administrasi");
        PetugasDesa p2 = new PetugasDesa("Hattori Heiji", "Staf Keuangan");
        PetugasDesa p3 = new PetugasDesa("Kaito Kuroba", "Bendahara Desa");

        
        PetugasDesa[] daftarPetugas = {p1, p2, p3};
        KantorDesa kantor = new KantorDesa("Desa Konoha", daftarPetugas);

       
        kantor.tampilkanData();

        System.out.println("\nJika KantorDesa dihapus, objek PetugasDesa tetap ada dan bisa dipakai lagi:");
        p1.tampilkanInfo(); 
        p2.tampilkanInfo(); 
        p3.tampilkanInfo(); 
    }
}

