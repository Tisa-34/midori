package Depedency;

public class Dokumen {
    private String namaDokumen;
    private String jenis;

    public Dokumen(String namaDokumen, String jenis) {
        this.namaDokumen = namaDokumen;
        this.jenis = jenis;
    }

    public String getNamaDokumen() {
        return namaDokumen;
    }

    public String getJenis() {
        return jenis;
    }
}

