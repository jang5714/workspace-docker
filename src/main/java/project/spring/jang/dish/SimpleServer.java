package project.spring.jang.dish;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class SimpleServer {
    private final  KitchenService kitchen;

    Flux<Dish> doingMyjob(){
        return this.kitchen.getDishes().map(dish -> Dish.deliver(dish));
    }
}
