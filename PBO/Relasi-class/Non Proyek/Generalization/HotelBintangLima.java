package Generalization;

public class HotelBintangLima extends Hotel {
    private String fasilitasMewah;

    public HotelBintangLima(String namaHotel, String alamat, String fasilitasMewah) {
        super(namaHotel, alamat);
        this.fasilitasMewah = fasilitasMewah;
    }

    public void layananVIP() {
        System.out.println("Layanan VIP tersedia untuk tamu eksklusif.");
    }

    @Override
    public void tampilkanInfoHotel() {
        super.tampilkanInfoHotel();
        System.out.println("Fasilitas Mewah: " + fasilitasMewah);
    }
}

