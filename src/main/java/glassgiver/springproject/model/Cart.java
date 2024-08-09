package glassgiver.springproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CartID;
    private int UserID;

    public Cart() {

    }

    public Cart(int cartID, int userID) {
        CartID = cartID;
        UserID = userID;
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int cartID) {
        CartID = cartID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }
}
