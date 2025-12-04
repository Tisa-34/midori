package Service;
import java.util.ArrayList;
import Model.Product;
public class ProductServiceDefault implements ProductService {
    private final ArrayList<Product> productList = new ArrayList<>();
    public ProductServiceDefault() {
        productList.add(new Product(1, "Laptop ASUS", 9500000));
        productList.add(new Product(2, "Monitor Dell", 2500000));
    }
@Override
    public void addProduct(String name, long price) {
        if (price <= 0) {
            throw new IllegalArgumentException(
                "Harga harus angka positif lebih dari 0");
        }
        int newId = productList.size() + 1;
        productList.add(new Product(newId, name, price));
    }
@Override
    public ArrayList<Product> getAllProducts() {
        return productList;
    }
}