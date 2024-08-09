package glassgiver.springproject.repositories.specifications;

import glassgiver.springproject.model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {

    public static Specification<Product> priceGreaterOrEquals(Integer price){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price)));
    }

    public static Specification<Product> priceLessOrEquals(Integer price){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price)));
    }

    public static Specification<Product> nameLike(String namePart){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%", namePart)));
    }
}
