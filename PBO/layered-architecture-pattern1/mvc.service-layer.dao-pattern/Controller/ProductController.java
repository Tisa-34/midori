package Controller;
import Service.ProductService;
import View.ProductConsoleView;
public class ProductController {
    private final ProductService service;
    private final ProductConsoleView view;
    public ProductController(ProductService service, ProductConsoleView view) {
        this.service = service;
        this.view = view;
    }
    public void handlingPilihanMenu(String pilihanMenu) {
        try {
            int menu = Integer.parseInt(pilihanMenu);
            switch (menu) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    view.displayMessage("Aplikasi ditutup.");
                    System.exit(0);
                    break;
                default:
                    view.displayMessage("Opsi tidak valid.");
            }
        } catch (NumberFormatException e) {
            view.displayError("Input tidak valid. Masukkan angka.");
        }
    }
    private void addNewProduct() {
        String name = view.getProductNameFromUser();
        String priceStr = view.getProductPriceFromUser();
        try {
            long price = Long.parseLong(priceStr);
            service.addProduct(name, price);
            view.displayMessage("Produk berhasil ditambahkan");
        } catch (Exception e) {
            view.displayError("Gagal menambah produk: " + e.getMessage());
        }
    }
    private void showAllProducts() {
        view.displayAllProducts(service.getAllProducts());
    }
}
