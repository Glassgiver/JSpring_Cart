package glassgiver.springproject.controllers;

import glassgiver.springproject.Services.CartService;
import glassgiver.springproject.components.Cart;
import glassgiver.springproject.model.Product;
import glassgiver.springproject.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private CartService cartService;

    @Autowired
    public MainController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/products")
    public List<Product> showAll(){
        return cartService.showAll();
    }

    @PostMapping("/cart/add/{id}")
    public void addToCart(@PathVariable int id){
        cartService.addToCart(id);
    }

    @PostMapping("/cart/remove/{id}")
    public void removeFromCart(@PathVariable int id){
        cartService.removeFromCart(id);
    }

    @GetMapping("/cart/showProducts")
    public List<Product> showProductsFromCart(){
        return cartService.showProductsFromCart();
    }

     @GetMapping("/cart/count")
     public int countProductsInCart(){
        return cartService.countProductsInCart();
     }


}
