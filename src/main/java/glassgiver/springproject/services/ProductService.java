package glassgiver.springproject.services;

import glassgiver.springproject.dtos.ProductDTO;
import glassgiver.springproject.model.Product;
import glassgiver.springproject.repositories.ProductRepository;
import glassgiver.springproject.repositories.specifications.ProductSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> findAll(Integer minPrice, Integer maxPrice, String partName, Integer page){
        Specification<Product> spec = Specification.where(null);
        if(minPrice != null){
            spec = spec.and(ProductSpecifications.priceGreaterOrEquals(minPrice));
        }
        if(maxPrice != null){
            spec = spec.and(ProductSpecifications.priceLessOrEquals(maxPrice));
        }
        if(partName != null){
            spec = spec.and(ProductSpecifications.nameLike(partName));
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 5));
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
