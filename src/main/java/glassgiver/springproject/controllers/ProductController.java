package glassgiver.springproject.controllers;

import glassgiver.springproject.exceptions.ResourceNotFoundException;
import glassgiver.springproject.model.Product;
import glassgiver.springproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public Page<Product> findAll(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minScore,
            @RequestParam(name = "max_price", required = false) Integer maxScore,
            @RequestParam(name = "name_Part", required = false) String namePart
    ){
        if(page < 1){
            page = 1;
        }
        return productService.findAll(minScore, maxScore, namePart, page);
    }
    @GetMapping("/price_between")
    public List<Product> findByPriceBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "1000") Integer max){
        return productService.findByPriceBetween(min, max);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
       return productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product is not found by id: " + id));
    }

//    @PostMapping("/addNewProduct")
//    public void addNewProduct(@RequestParam String name, @RequestParam int price){
//        productService.addNewProduct(name, price);
//    }

    @PostMapping("/addNewProduct")
    public Product save(@RequestBody Product product){
        product.setId(null);
        return productService.save(product);
    }

}
