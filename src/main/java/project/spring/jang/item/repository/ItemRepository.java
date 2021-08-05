package project.spring.jang.item.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import project.spring.jang.item.entity.Item;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
}
