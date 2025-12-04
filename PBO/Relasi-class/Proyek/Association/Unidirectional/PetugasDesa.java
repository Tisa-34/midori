package Association.Unidirectional;

public class PetugasDesa {
    private String nama;
    private KantorDesa kantor; 
    public PetugasDesa(String nama, KantorDesa kantor) {
        this.nama = nama;
        this.kantor = kantor;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Petugas: " + nama);
        System.out.println("Bekerja di:");
        kantor.tampilkanInfo(); 
    }
}
