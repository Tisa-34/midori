package Association.Bidirectional;

public class Tamu {
    private String namaTamu;
    private Hotel hotel;

    public Tamu(String namaTamu) {
        this.namaTamu = namaTamu;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public void tampilkanHotel() {
        if (hotel != null) {
            System.out.println(namaTamu + " menginap di " + hotel.getNamaHotel());
        } else {
            System.out.println(namaTamu + " belum menginap di hotel mana pun.");
        }
    }
}

