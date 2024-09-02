package glassgiver.springproject.exceptions;

import glassgiver.springproject.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldValidationError extends RuntimeException {
    private List<String> errorFieldMessage;

}
