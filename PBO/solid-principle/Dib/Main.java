package Dib;
public class Main {
    public static void main(String[] args) {
        Database mysql = new MySQL();
        UserService layananMySQL = new UserService(mysql);
        layananMySQL.daftarPengguna("Kudo Shinichi");
        System.out.println();
        Database postgre = new PostgreSQL();
        UserService layananPostgre = new UserService(postgre);
        layananPostgre.daftarPengguna("Kuroba Kaito");
    }
}

