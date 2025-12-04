package Dib;

public class MySQL implements Database {
    @Override
    public void insert(String data) {
        System.out.println("Data '" + data + "' berhasil dimasukkan ke database MySQL.");
    }
}
