package Association.Unidirectional;

public class Tamu {
    private String namaTamu;
    private Hotel hotel; 

    public Tamu(String namaTamu, Hotel hotel) {
        this.namaTamu = namaTamu;
        this.hotel = hotel;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Tamu  : " + namaTamu);
        System.out.println("Menginap di: " + hotel.getNamaHotel());
    }
}

