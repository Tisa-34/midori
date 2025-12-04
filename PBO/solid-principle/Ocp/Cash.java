package Ocp;


public class Cash implements TipePembayaran {
    @Override
    public void memprosesPembayaran() {
        System.out.println("Memproses pembayaran menggunakan uang Cash...");
    }
}
