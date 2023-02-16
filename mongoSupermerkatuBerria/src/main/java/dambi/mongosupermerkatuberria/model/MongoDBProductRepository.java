package dambi.mongosupermerkatuberria.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.*;

@Repository
public class MongoDBProductRepository implements ProductRepository {
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    @Autowired
    private MongoClient client;
    private MongoCollection<Product> productCollection;

    @PostConstruct
    void init() {
        productCollection = client.getDatabase("berreskurapena").getCollection("supermerkatua", Product.class);
    }

    @Override
    public List<Product> findAll() {
        return productCollection.find().into(new ArrayList<>());
    }

    @Override
    public Product productById(int id) {
        return productCollection.find(eq("_id", id)).first();
    }

    @Override
    public List<Product> productByName(String productName) {
        return productCollection.find(eq("product_name", productName)).into(new ArrayList<>());
    }

    @Override
    public List<Product> productByCategory(String category) {
        return productCollection.find(eq("categories", category)).into(new ArrayList<>());
    }

    @Override
    public List<Product> productByOrigin(String origin) {
        return productCollection.find(eq("origin", origin)).into(new ArrayList<>());
    }

    @Override
    public List<Product> productCheaperThan(double price) {
        return productCollection.find(lt("price", price)).into(new ArrayList<>());
    }

    @Override
    public List<Product> productInStock() {
        return productCollection.find(eq("is_in_stock", true)).into(new ArrayList<>());
    }

    @Override
    public List<Product> productInStockAndCheaperThan(double price) {
        return productCollection.find(and(lt("price", price), eq("is_in_stock", true))).into(new ArrayList<>());
    }

    @Override
    public Product save(Product product) {
        productCollection.insertOne(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        productCollection.replaceOne(eq("_id", product.get_id()), product);
        return product;
    }

    @Override
    public void delete(Product product) {
        productCollection.deleteOne(eq("_id", product.get_id()));
    }
}
