package Dib;

public class UserService {
    private Database database;
    public UserService(Database database) {
        this.database = database;
    }
    public void daftarPengguna(String namaPengguna) {
        System.out.println("Mendaftarkan pengguna: " + namaPengguna);
        database.insert(namaPengguna);
    }
}

