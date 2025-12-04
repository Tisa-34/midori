package Composition;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Indramayu Jaya", "A101", "Deluxe");
        hotel.tampilkanInfo();

        
        hotel = null;
        System.out.println("\nHotel telah dihapus, kamar juga tidak dapat diakses lagi.");
    }
}
