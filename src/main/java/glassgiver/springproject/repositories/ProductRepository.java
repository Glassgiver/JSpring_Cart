package glassgiver.springproject.repositories;

import glassgiver.springproject.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(List.of(
                new Product(1, "Apple", 200),
                new Product(2, "Juice", 600),
                new Product(3, "Chips", 800),
                new Product(4, "Pen", 100),
                new Product(5, "Banana", 700)
        ));

    }


    public Optional<Product> getById(int req){
        return productList.stream()
                .filter(product -> product.getId() == req)
                .findFirst();
    }

    public List<Product> getAll(){
        return Collections.unmodifiableList(productList);
    }
}
