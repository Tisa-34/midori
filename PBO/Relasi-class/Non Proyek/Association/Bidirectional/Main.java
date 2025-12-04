package Association.Bidirectional;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Murasaki Midori");

        Tamu tamu1 = new Tamu("Kudo Shinichi");
        Tamu tamu2 = new Tamu("Monkey D. Luffy");

        hotel.tambahTamu(tamu1);
        hotel.tambahTamu(tamu2);

        hotel.tampilkanTamu();

        tamu1.tampilkanHotel();
        tamu2.tampilkanHotel();
    }
}

