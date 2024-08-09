package glassgiver.springproject.controllers;

import glassgiver.springproject.exceptions.ResourceNotFoundException;
import glassgiver.springproject.model.Product;
import glassgiver.springproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return productService.showAll();
    }
    @GetMapping("/products/price_between")
    public List<Product> demo(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "1000") Integer max){
        return productService.findByPriceBetween(min, max);
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id){
       return productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product is not found by id: " + id));
    }

//    @PostMapping("/products/addNewProduct")
//    public void addNewProduct(@RequestParam String name, @RequestParam int price){
//        productService.addNewProduct(name, price);
//    }

    @PostMapping("/products/addNewProduct")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

}
