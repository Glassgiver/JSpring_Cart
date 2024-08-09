package glassgiver.springproject.model;

import java.io.Serializable;
import java.util.Objects;

public class CartItemId implements Serializable {
    private Integer cartId;
    private Integer productId;

    public CartItemId() {}

    public CartItemId(Integer cartId, Integer productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemId that = (CartItemId) o;
        return Objects.equals(cartId, that.cartId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId);
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
