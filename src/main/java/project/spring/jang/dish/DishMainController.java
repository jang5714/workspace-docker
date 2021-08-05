package project.spring.jang.dish;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RequiredArgsConstructor
@RestController
public class DishMainController {
    private final KitchenServices kitchenServices;
    @GetMapping(value = "/dishes", produces = "application/json; charset=utf8")
    Flux<Dishs> serveDishes(){
        return kitchenServices.getDishes();
    }

}
