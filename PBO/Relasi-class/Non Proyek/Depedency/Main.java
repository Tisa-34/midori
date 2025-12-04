package Depedency;

public class Main {
    public static void main(String[] args) {
    
        Kamar kamar1 = new Kamar(201, 650000);

        
        Booking booking1 = new Booking("Aoi Midori", kamar1);

        
        Pembayaran pembayaranTunai = new Pembayaran("Tunai");

       
        booking1.lakukanBooking(pembayaranTunai);
    }
}

