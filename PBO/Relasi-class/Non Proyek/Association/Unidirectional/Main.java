package Association.Unidirectional;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Murasaki Midori", "Jl. Raya Yumeni No. 12");
        Tamu tamu = new Tamu("Kudo Shinichi", hotel);

        tamu.tampilkanInfo();
    }
}
