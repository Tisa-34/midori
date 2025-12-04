package Isp;

public class Main {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(5);
        Kubus kubus = new Kubus(5);

        System.out.println("=== Program Perhitungan Bangun ===");
        System.out.println("Luas Persegi: " + persegi.hitungLuas());
        System.out.println("Luas Permukaan Kubus: " + kubus.hitungLuas());
        System.out.println("Volume Kubus: " + kubus.hitungVolume());
    }
}

