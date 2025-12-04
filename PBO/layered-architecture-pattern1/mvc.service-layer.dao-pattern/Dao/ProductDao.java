package Dao;
import java.util.ArrayList;
import Model.Product;
public interface ProductDao {
    void save(Product product);
    ArrayList<Product> findAll();
}
