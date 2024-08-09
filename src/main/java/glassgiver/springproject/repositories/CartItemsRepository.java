package glassgiver.springproject.repositories;

import glassgiver.springproject.model.Cart;
import glassgiver.springproject.model.CartItem;
import glassgiver.springproject.model.CartItemId;
import glassgiver.springproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItem, CartItemId> {
}
