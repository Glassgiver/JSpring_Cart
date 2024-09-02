package glassgiver.springproject.controllers;

import glassgiver.springproject.converters.ProductConverter;
import glassgiver.springproject.dtos.ProductDTO;
import glassgiver.springproject.exceptions.ResourceNotFoundException;
import glassgiver.springproject.model.Product;
import glassgiver.springproject.services.ProductService;
import glassgiver.springproject.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @GetMapping()
    public Page<ProductDTO> findAll(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minScore,
            @RequestParam(name = "max_price", required = false) Integer maxScore,
            @RequestParam(name = "name_Part", required = false) String namePart
    ){
        if(page < 1){
            page = 1;
        }
        return productService.findAll(minScore, maxScore, namePart, page)
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()));
    }
    @GetMapping("/price_between")
    public List<ProductDTO> findByPriceBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "1000") Integer max){
        return  productService.findByPriceBetween(min, max).stream().map(productConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
       Product product = productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product is not found by id: " + id));
       return productConverter.entityToDto(product);
    }

//    @PostMapping("/addNewProduct")
//    public void addNewProduct(@RequestParam String name, @RequestParam int price){
//        productService.addNewProduct(name, price);
//    }

    @PostMapping("/addNewProduct")
    public ProductDTO save(@RequestBody ProductDTO productDTO){
        productValidator.validate(productDTO);
        Product product = productConverter.dtoToEntity(productDTO);
        product.setId(null);
        Product save = productService.save(product);
        return productConverter.entityToDto(save);
    }



}
