package Dib;

public class PostgreSQL implements Database {
    @Override
    public void insert(String data) {
        System.out.println("Data '" + data + "' berhasil dimasukkan ke database PostgreSQL.");
    }
}
