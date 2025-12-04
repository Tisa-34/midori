package Generalization;

public class Main {
    public static void main(String[] args) {
        HotelBintangLima h1 = new HotelBintangLima("Hotel Grand Indramayu", "Jl. Pantai Karangsong", "Kolam Renang & Spa");
        HotelMelati h2 = new HotelMelati("Hotel Mawar", "Jl. Raya Indramayu", true);

        System.out.println("=== Informasi Hotel Bintang Lima ===");
        h1.tampilkanInfoHotel();
        h1.layananVIP();

        System.out.println("\n=== Informasi Hotel Melati ===");
        h2.tampilkanInfoHotel();
        h2.layananEkonomis();
    }
}

