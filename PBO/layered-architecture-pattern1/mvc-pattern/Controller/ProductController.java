package Controller;
import java.util.ArrayList;
import Model.Product;
import View.ProductConsoleView;
public class ProductController {
    private final ProductConsoleView View;
    private final ArrayList<Product> Model = new ArrayList<>();
    public ProductController(ProductConsoleView View){
        this.View = View;
        Model.add(new Product(1, "Laptop Asus", 9500000));
        Model.add(new Product(2, "Monitor Dell", 2500000));
    }
    public void handlingPilihanMenu(int pilihanMenu) {
    switch (pilihanMenu) {
        case 1:
            displayProductsAction();
            break;
        case 2:
            addProductAction();
            break;
        case 3:
            View.displayMessage("Keluar dari aplikasi.");
            break;
        default:
            View.displayError("Opsi tidak valid.");
    }
}
private void displayProductsAction() {
    View.displayAllProduct(Model);
}
private void addProductAction() {
    String name = View.getProductNameFromUser();
    String priceStr = View.getProductPriceFromUser();
    try {
        long price = Long.parseLong(priceStr);
        if (price <= 0) {
            throw new IllegalArgumentException(
                "Harga harus angka positif lebih dari 0.");
        }
        int newId = Model.size() + 1;
        Model.add(new Product(newId, name, price));
        View.displayMessage("Produk berhasil ditambahkan!");
    } catch (IllegalArgumentException e) {
        View.displayError("Gagal menambah produk: " + e.getMessage());
    }
}
}
