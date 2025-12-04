package Realization;

public class PelayananKK implements PelayananMasyarakat {
    @Override
    public void prosesPermohonan(String namaPemohon) {
        System.out.println("Memproses permohonan pembuatan Kartu Keluarga untuk " + namaPemohon);
    }

    @Override
    public void cetakDokumen(String namaPemohon) {
        System.out.println("Mencetak Kartu Keluarga atas nama " + namaPemohon);
    }
}
