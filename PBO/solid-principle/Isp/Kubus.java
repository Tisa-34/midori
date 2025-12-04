package Isp;

public class Kubus implements Bentuk2Dimensi, Bentuk3Dimensi {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return 6 * sisi * sisi;
    }

    @Override
    public double hitungVolume() {
        return sisi * sisi * sisi;
    }
}
