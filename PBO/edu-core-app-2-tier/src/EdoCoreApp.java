import Config.DatabaseConnection;

public class EdoCoreApp {
    public static void main(String[] args) throws Exception {
        System.out.println(DatabaseConnection.getConnection());
    }
}
