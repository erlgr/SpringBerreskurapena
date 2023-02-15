package dambi.mongosupermerkatuberria.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findAll();

    Product productById(int id);

    List<Product> productByName(String productName);

    List<Product> productByCategory(String category);

    List<Product> productByOrigin(String origin);

    List<Product> productCheaperThan(double price);

    List<Product> productInStock();

    List<Product> productInStockAndCheaperThan(double price);
    Product save(Product product);

    Product update(Product product);

    void delete(Product product);
}
