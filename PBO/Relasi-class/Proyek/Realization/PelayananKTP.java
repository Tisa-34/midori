package Realization;

public class PelayananKTP implements PelayananMasyarakat {
    @Override
    public void prosesPermohonan(String namaPemohon) {
        System.out.println("Memproses permohonan pembuatan KTP untuk " + namaPemohon);
    }

    @Override
    public void cetakDokumen(String namaPemohon) {
        System.out.println("Mencetak KTP atas nama " + namaPemohon);
    }
}
