package Generalization;

public class HotelMelati extends Hotel {
    private boolean sarapanGratis;

    public HotelMelati(String namaHotel, String alamat, boolean sarapanGratis) {
        super(namaHotel, alamat);
        this.sarapanGratis = sarapanGratis;
    }

    public void layananEkonomis() {
        System.out.println("Layanan ekonomis untuk wisatawan dengan anggaran terbatas.");
    }

    @Override
    public void tampilkanInfoHotel() {
        super.tampilkanInfoHotel();
        System.out.println("Sarapan Gratis: " + (sarapanGratis ? "Ya" : "Tidak"));
    }
}
