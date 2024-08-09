package glassgiver.springproject.model;

import jakarta.persistence.*;

@Entity
@IdClass(CartItemId.class)
public class CartItem {

    @Id
    private Integer cartId;

    @Id
    private Integer productId;

    private Integer quantity;


}
