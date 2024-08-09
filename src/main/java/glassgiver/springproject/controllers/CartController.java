package glassgiver.springproject.controllers;

import glassgiver.springproject.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart/add/{id}")
    public void add(@PathVariable int id){
//        cartService.addToCart(id);
    }

    @PostMapping("/cart/remove/{id}")
    public void remove(@PathVariable int id){
        cartService.remove(id);
    }

    @GetMapping("/cart/showProducts")
    public void showProducts(){

    }
//    public List<Product> showProductsFromCart(){
//        return cartService.showProductsFromCart();
//    }

    @GetMapping("/cart/count")
    public void countProducts(){

    }
     /*public int countProductsInCart(){
        return cartService.countProductsInCart();
     }*/

}
