package Ocp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PembayaranCustomer customer = new PembayaranCustomer();

        System.out.println("=== Pilih Metode Pembayaran ===");
        System.out.println("1. Debit");
        System.out.println("2. Kredit");
        System.out.println("3. Cash");
        System.out.print("Pilihan Anda: ");
        int pilihan = input.nextInt();

        TipePembayaran tipe = null;

        switch (pilihan) {
            case 1:
                tipe = new Debit();
                break;
            case 2:
                tipe = new Kredit();
                break;
            case 3:
                tipe = new Cash();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                System.exit(0);
        }

        customer.menerimaPembayaran(tipe);
        input.close();
    }
}
