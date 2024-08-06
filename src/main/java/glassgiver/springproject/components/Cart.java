package glassgiver.springproject.components;

import glassgiver.springproject.repositories.ProductRepository;
import glassgiver.springproject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class Cart {
    private final List<Product> products = new ArrayList<>();
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(int id){
        Optional<Product> productOptional = productRepository.getById(id);
        productOptional.ifPresent(products::add);
    }

    public void removeProduct(int id){
        products.removeIf(product -> product.getId() == id);
    }

    public List<Product> getProducts(){
        return products;
    }

    public String showProd(){
        return products.stream().map(Product::getName).collect(Collectors.joining(", "));
    }

    public int countProducts() {
        return products.size();
    }
}
