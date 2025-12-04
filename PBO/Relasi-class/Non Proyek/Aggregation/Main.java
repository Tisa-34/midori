package Aggregation;


public class Main {
    public static void main(String[] args) {
       
        Kamar k1 = new Kamar(101, 350000);
        Kamar k2 = new Kamar(102, 450000);
        Kamar k3 = new Kamar(103, 550000);

        
        Kamar[] daftarKamar = { k1, k2, k3 };

        
        Hotel hotel = new Hotel("Hotel Grand Midori", daftarKamar);

        hotel.tampilkanInfoHotel();

        System.out.println("\nCek: Objek Kamar tetap dapat diakses walaupun Hotel tidak digunakan:");
        k1.tampilkanInfoKamar();
    }
}
