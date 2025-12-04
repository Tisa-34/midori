package Srp;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan panjang sisi persegi: ");
        int sisi = input.nextInt();

        Persegi persegi = new Persegi(sisi);
        PenghitungPersegi penghitung = new PenghitungPersegi();

        int luas = penghitung.hitungLuas(persegi);
        System.out.println("Luas persegi = " + luas);

        input.close();
    }
}
