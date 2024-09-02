package glassgiver.springproject.validators;

import glassgiver.springproject.dtos.ProductDTO;
import glassgiver.springproject.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    public void validate(ProductDTO productDTO) throws ValidationException {
        List<String> list = new ArrayList<>();
        if(productDTO.getPrice() < 1){
            list.add("Цена продукта не может быть меньше 1");
        }

        if(productDTO.getName().isBlank()){
            list.add("Продукт не может иметь пустое название");
        }
        if(!list.isEmpty()){
            throw new ValidationException(list);
        }
    }

}
