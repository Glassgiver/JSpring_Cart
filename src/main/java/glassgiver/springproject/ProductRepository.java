package glassgiver.springproject;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init(){
        products.add(new Product(1, "Apple", 200));
        products.add(new Product(2, "Juice", 600));
        products.add(new Product(3, "Chips", 800));
        products.add(new Product(4, "Pen", 100));
        products.add(new Product(5, "Banana", 700));
    }


    public Optional<Product> getById(int req){
        return products.stream()
                .filter(product -> product.getId() == req)
                .findFirst();
    }

    public List<Product> getAll(){
        return products;
    }
}
