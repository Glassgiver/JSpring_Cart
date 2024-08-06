package glassgiver.springproject.Services;

import glassgiver.springproject.components.Cart;
import glassgiver.springproject.model.Product;
import glassgiver.springproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CartService {
    private ProductRepository productRepository;
    private Cart cart;

    @Autowired
    public CartService(ProductRepository productRepository, Cart cart ){
        this.productRepository = productRepository;
        this.cart = cart;
    }
    public List<Product> showAll(){
        return productRepository.getAll();
    }

    public void addToCart(int id){
        cart.addProduct(id);
    }

    public List<Product> showProductsFromCart(){
        return cart.getProducts();
    }

    public int countProductsInCart() {
        return cart.countProducts();
    }

    public void removeFromCart(int id) {
        cart.removeProduct(id);
    }
}
