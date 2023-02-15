package dambi.mongosupermerkatuberria.controller;

import dambi.mongosupermerkatuberria.model.Product;
import dambi.mongosupermerkatuberria.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/save")
    public @ResponseBody Product produktuaGorde(Product product) {
        return productRepository.save(product);
    }

    @GetMapping(path = "/update")
    public @ResponseBody Product produktuaEguneratu(Product product) {
        return productRepository.update(product);
    }

    @GetMapping(path = "/delete")
    public void produktuaEzabatu(Product product) {
        productRepository.delete(product);
    }
}
