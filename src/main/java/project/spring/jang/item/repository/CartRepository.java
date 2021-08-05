package project.spring.jang.item.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import project.spring.jang.item.entity.Cart;

public interface CartRepository extends ReactiveCrudRepository<Cart, String> {
}
