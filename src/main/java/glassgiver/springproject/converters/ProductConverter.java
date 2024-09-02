package glassgiver.springproject.converters;

import glassgiver.springproject.dtos.ProductDTO;
import glassgiver.springproject.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDTO productDTO){
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice());
    }

    public ProductDTO entityToDto(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getPrice());
    }

}
