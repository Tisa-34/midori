import java.util.Scanner;
import Controller.ProductController;
import Dao.ProductDao;
import Dao.Memory.ProductDaoInMemory;
import Service.ProductService;
import Service.ProductServiceDefault;
import View.ProductConsoleView;
public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoInMemory();
        ProductService productService = new ProductServiceDefault(productDao);
        Scanner scanner = new Scanner(System.in);
        ProductConsoleView productView = new ProductConsoleView(scanner);
        ProductController productController = new ProductController(productService, productView);
        while (true) {
            productView.displayMenu();
            String pilihanMenu = productView.getPilihanMenuFromUser();
            productController.handlingPilihanMenu(pilihanMenu);
        }
    }
}