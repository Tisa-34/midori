package View;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Product;
public class ProductConsoleView {
    private final Scanner scanner;
    public ProductConsoleView(Scanner scanner){
        this.scanner = scanner;
    }
    public void displayAllProduct(ArrayList<Product> products){
        System.out.println("\n=== Daftar Produk ===");
        if (products.isEmpty()) {
            System.out.println("Tidak Ada Produk Tersedia.");
        } else {
            for(Product product : products) {
                System.out.println(product.getId() + "-" + product.getName() + "Rp. " + product.getPrice());
            }
        }
    }    
    public String getProductNameFromUser() {
        System.out.println("Masukan Nama Produk");
        return scanner.nextLine();
    }
    public String getProductPriceFromUser() {
        System.out.println("Masukan Harga Produk");
        return scanner.nextLine();
    }
    public void displayMessage(String message) {
        System.out.println("INFO: " + message);
    }
    public void displayError(String message) {
        System.out.println("ERROR: " + message);
    }
}
