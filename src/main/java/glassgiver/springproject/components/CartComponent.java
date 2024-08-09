package glassgiver.springproject.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CartComponent {
//    private final List<Product> products = new ArrayList<>();
//    @Autowired
//    private ProductRepository productRepository;
//
//    public void addProduct(long id){
//        Optional<Product> productOptional = productRepository.findById(id);
//        productOptional.ifPresent(products::add);
//    }
//
//    public void removeProduct(int id){
//        products.removeIf(product -> product.getId() == id);
//    }
//
//    public List<Product> getProducts(){
//        return products;
//    }
//
//    public String showProd(){
//        return products.stream().map(Product::getName).collect(Collectors.joining(", "));
//    }
//
//    public int countProducts() {
//        return products.size();
//    }
}
