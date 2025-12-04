package Composition;

public class ArsipSurat {
    private String nomorSurat;
    private String jenisSurat;

    public ArsipSurat(String nomorSurat, String jenisSurat) {
        this.nomorSurat = nomorSurat;
        this.jenisSurat = jenisSurat;
    }

    public void tampilkanArsip() {
        System.out.println("Nomor Surat : " + nomorSurat);
        System.out.println("Jenis Surat : " + jenisSurat);
    }
}
