package Association.Unidirectional;

public class KantorDesa {
    private String namaDesa;
    private String alamat;

    public KantorDesa(String namaDesa, String alamat) {
        this.namaDesa = namaDesa;
        this.alamat = alamat;
    }

    public String getNamaDesa() {
        return namaDesa;
    }

    public String getAlamat() {
        return alamat;
    }

    public void tampilkanInfo() {
        System.out.println("Kantor Desa: " + namaDesa);
        System.out.println("Alamat     : " + alamat);
    }
}
