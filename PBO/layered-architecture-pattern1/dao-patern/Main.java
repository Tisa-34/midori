//import java.util.ArrayList;
import java.util.Scanner;
import Dao.ProductDao;
import Dao.Memory.ProductDaoInMemory;
import Model.Product;
public class Main {
    private final ProductDao productDao = new ProductDaoInMemory();
    private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main app = new Main();
        app.startMenu();
        app.scanner.close();
    }
    public void startMenu() {
        boolean running = true;
        while (running) {
            System.out.println("---< APLIKASI DAO PATTERN >---");
            System.out.println("1. Tampilkan Semua Produk");
            System.out.println("2. Tambah Produk Baru");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                        addNewProduct();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Opsi tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Input error: " + e.getMessage());
            }
        }
    }
    private void displayProducts() {
        System.out.println("---< Daftar Produk >---");
        for (Product product : productDao.findAll()) {
            System.out.println(product);
        }
    }
    private void addNewProduct() {
        System.out.print("Nama produk: ");
        String name = scanner.nextLine();
        System.out.print("Harga produk: ");
        String priceStr = scanner.nextLine();
        long price;
        try {
            price = Long.parseLong(priceStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: Harga harus angka.");
            return;
        }
        if (price <= 0) {
            System.out.println("Error: Harga harus angka positif lebih dari 0.");
            return;
        }
        int newId = productDao.findAll().size() + 1;
        productDao.save(new Product(newId, name, price));
        System.out.println("Produk berhasil ditambahkan.");
    }
}