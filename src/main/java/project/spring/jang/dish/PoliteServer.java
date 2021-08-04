package project.spring.jang.dish;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PoliteServer {
    private final KitchenService kitchen;

    Flux<Dish> doingMyjob(){
        return this.kitchen.getDishes().doOnNext(dish -> System.out.println("Thank you for"+dish+"!"))
                .doOnError(error -> System.out.println("So sorry about" + error.getMessage()))
                .doOnComplete(()-> System.out.println("Thanks for all your hard work!"))
                .map(Dish::deliver);
    }
}
