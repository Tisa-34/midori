package Realization;

public class HotelBintangLima implements LayananHotel {
    private String namaHotel;

    public HotelBintangLima(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    @Override
    public void pesanKamar(String namaTamu, int jumlahMalam) {
        System.out.println("Tamu " + namaTamu + " memesan kamar di " + namaHotel + " untuk " + jumlahMalam + " malam.");
    }

    @Override
    public void layananKamar(String namaTamu) {
        System.out.println("Layanan kamar dikirim untuk tamu " + namaTamu + ".");
    }

    @Override
    public void checkOut(String namaTamu) {
        System.out.println("Tamu " + namaTamu + " telah check-out dari " + namaHotel + ".");
    }
}
