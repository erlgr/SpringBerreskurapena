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
import static com.mongodb.client.model.Filters.eq;

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
        return null;
    }

    @Override
    public List<Product> productByName(String productName) {
        return null;
    }

    @Override
    public List<Product> productByCategory(String category) {
        return null;
    }

    @Override
    public List<Product> productByOrigin(String origin) {
        return null;
    }

    @Override
    public List<Product> productCheaperThan(double price) {
        return null;
    }

    @Override
    public List<Product> productInStock() {
        return null;
    }

    @Override
    public List<Product> productInStockAndCheaperThan(double price) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Product product) {

    }
}
