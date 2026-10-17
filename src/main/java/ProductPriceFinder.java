
import java.util.HashMap;

public class ProductPriceFinder {
    public static void main(String[] args) {
        HashMap<String, Double> products = new HashMap<>();

        products.put("Laptop", 55000.0);
        products.put("Phone", 25000.0);
        products.put("Tablet", 18000.0);
        products.put("Headphones", 2000.0);

        String searchProduct = "Phone";

        if (products.containsKey(searchProduct)) {
            System.out.println(searchProduct + " price: "
                    + products.get(searchProduct));
        } else {
            System.out.println("Product not found");
        }
    }
}
