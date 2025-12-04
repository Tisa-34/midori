package Realization;

public class Main {
    public static void main(String[] args) {
        LayananHotel hotel = new HotelBintangLima("Grand Murasaki Hotel");

        hotel.pesanKamar("Aoi Midori", 3);
        hotel.layananKamar("Aoi Midori");
        hotel.checkOut("Aoi Midori");
    }
}
