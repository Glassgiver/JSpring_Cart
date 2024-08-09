package glassgiver.springproject.services;

import glassgiver.springproject.model.Product;
import glassgiver.springproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> showAll(){
        return productRepository.findAll();
    }

    public List<Product> findByPriceBetween(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min, max);
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

//    public void addNewProduct(String name, int price) {
//        Product product = new Product(name, price);
//        productRepository.save(product);
//    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
