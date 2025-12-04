import java.util.List;
import java.util.Scanner;
import Model.Product;
import Service.ProductServiceDefault;
public class Main {
    private final ProductServiceDefault productService = new ProductServiceDefault();
    private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main app = new Main();
        app.startMenu();
        app.scanner.close();
    }
    public void startMenu() {
        boolean running = true;
        while (running) {
            System.out.println("---< APLIKASI SERVICE LAYER PATTERN >---");
            System.out.println("1. Tampilkan Semua Produk");
            System.out.println("2. Tambah Produk Baru");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayAllProducts();
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
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }
    }
    private void displayAllProducts() {
        System.out.println("---< Daftar Produk >---");
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + " - " + product.getName() + " - Rp. " + product.getPrice());
        }
    }
    private void addNewProduct() {
        System.out.print("Masukkan Nama Produk: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan Harga Produk: ");

        try {
            long price = Long.parseLong(scanner.nextLine());
            productService.addProduct(name, price);
            System.out.println("Produk berhasil ditambahkan");
        } catch (NumberFormatException e) {
            System.out.println("Input harga tidak valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}