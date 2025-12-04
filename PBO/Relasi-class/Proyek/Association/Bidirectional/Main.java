package Association.Bidirectional;

public class Main {
    public static void main(String[] args) {
        PetugasDesa petugas = new PetugasDesa("Pak Yusaku Kudo");

        Warga warga1 = new Warga("Monkey D. Luffy");
        Warga warga2 = new Warga("Kudo Shinichi");

        
        petugas.tambahWarga(warga1);
        petugas.tambahWarga(warga2);

        
        System.out.println("=== Data Petugas Desa ===");
        petugas.tampilkanWarga();

        System.out.println("\n=== Data Warga ===");
        warga1.tampilkanInfo();
        warga2.tampilkanInfo();
    }
}

