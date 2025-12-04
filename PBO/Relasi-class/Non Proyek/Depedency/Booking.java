package Depedency;

public class Booking {
    private String namaPelanggan;
    private Kamar kamarDipesan;

    public Booking(String namaPelanggan, Kamar kamarDipesan) {
        this.namaPelanggan = namaPelanggan;
        this.kamarDipesan = kamarDipesan;
    }

    
    public void lakukanBooking(Pembayaran pembayaran) {
        System.out.println("\n Pemesanan kamar oleh " + namaPelanggan);
        kamarDipesan.tampilkanInfoKamar();
        pembayaran.prosesPembayaran(kamarDipesan.getHarga());
    }
}

