package Service;
import java.util.ArrayList;
import Model.Product;
public interface ProductService {
    void addProduct(String name, long price);
    ArrayList<Product> getAllProducts();
}