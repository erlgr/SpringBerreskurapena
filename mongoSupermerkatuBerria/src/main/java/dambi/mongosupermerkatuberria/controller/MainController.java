package dambi.mongosupermerkatuberria.controller;

import dambi.mongosupermerkatuberria.model.Product;
import dambi.mongosupermerkatuberria.model.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/supermerkatua")
public class MainController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/allProducts")
    public @ResponseBody Iterable<Product> produktuGuztiak() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/productById")
    public @ResponseBody Product produktuaIdz(int id) {
        return productRepository.productById(id);
    }

    @GetMapping(path = "/productByName")
    public @ResponseBody Iterable<Product> produktuaIzena(String productName) {
        return productRepository.productByName(productName);
    }

    @GetMapping(path = "/productByCategory")
    public @ResponseBody Iterable<Product> produktuaKategoria(String category) {
        return productRepository.productByCategory(category);
    }

    @GetMapping(path = "/productByOrigin")
    public @ResponseBody Iterable<Product> produktuaJatorria(String origin) {
        return productRepository.productByOrigin(origin);
    }

    @GetMapping(path = "/productCheaperThan")
    public @ResponseBody Iterable<Product> produktuaGuztiakPrezioGutxiago(double price) {
        return productRepository.productCheaperThan(price);
    }

    @GetMapping(path = "/productInStock")
    public @ResponseBody Iterable<Product> produktuaGuztiakStockean() {
        return productRepository.productInStock();
    }

    @GetMapping(path = "/productInStockAndCheaperThan")
    public @ResponseBody Iterable<Product> produktuaGuztiakStockeanPrezioGutxiago(double price) {
        return productRepository.productInStockAndCheaperThan(price);
    }

    @PostMapping(path = "/save")
    public @ResponseBody Product produktuaGorde(int id, String productName, double price, Date deliveryDate, String origin, Boolean isInStock) {
        Product product = new Product();
        product.setId(id);
        product.setProduct_name(productName);
        product.setPrice(price);
        product.setDelivery_date(deliveryDate);
        product.setOrigin(origin);
        product.setIs_in_stock(isInStock);
        productRepository.save(product);
        return product;
    }

    @PutMapping(path = "/update")
    public Product produktuaEguneratu(@Valid int id, String productName, double price, String origin, boolean isInStock) {
        try {
            Product product = productRepository.productById(id);
            product.setId(id);
            product.setProduct_name(productName);
            product.setPrice(price);
            product.setDelivery_date(productRepository.productById(id).getDelivery_date());
            product.setOrigin(origin);
            product.setIs_in_stock(isInStock);
            product.setCategories(productRepository.productById(id).getCategories());
            productRepository.update(product);
            return product;
        } catch (Exception e) {
            return null;
        }

    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody void produktuaEzabatu(int id) {
        try {
            productRepository.delete(productRepository.productById(id));
        } catch (Exception e) {
            System.out.println("Ez da produktu hori aurkitu");
        }
    }

}
