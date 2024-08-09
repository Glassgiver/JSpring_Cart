package glassgiver.springproject.services;

import glassgiver.springproject.repositories.CartItemsRepository;
import glassgiver.springproject.repositories.CartRepository;
import glassgiver.springproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartItemsRepository cartItemsRepository;
    private ProductRepository productRepository;

    @Autowired
    public CartService(CartItemsRepository cartItemsRepository, CartRepository cartRepository, ProductRepository productRepository ){
        this.cartItemsRepository = cartItemsRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


//    public void addToCart(long id){
//        cartItemsRepository.save();
//    }

//    public List<Product> showProductsFromCart(){
//        return cartRepository.findAll();
//    }

//    public int countProductsInCart() {
//        return cartRepository.countProducts();
//    }

    public void remove(long id) {
        cartRepository.deleteById(id);
    }


}
