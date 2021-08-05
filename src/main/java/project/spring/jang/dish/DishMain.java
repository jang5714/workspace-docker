package project.spring.jang.dish;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import lombok.Data;

@Data
class Dishs {
    private String description;
    private  boolean delivered = false;

    Dishs(String description){
        this.description = description;
    }

    public static Dishs deliver(Dishs dishs){
        Dishs delivereDish = new Dishs(dishs.description);
        delivereDish.delivered = true;
        return delivereDish;
    }
    public String toString(){
        return delivered ? description + "먹는다" : description + "기다린다";
    }
}
class KitchenServices {
    Flux<Dishs> getDishes(){
        return Flux.just(new Dishs("김치찌개"),
                new Dishs("떡볶이"),
                new Dishs("삼계탕"));
    }
}
@RequiredArgsConstructor class PrototypeServer {
    private final KitchenServices kitchen;
    Flux<Dishs> doingMyJob(){
        return kitchen.getDishes().map(dishs -> Dishs.deliver((dishs)));
    }
}
@RequiredArgsConstructor class AdvancedServer {
    private final KitchenServices kitchen;

    Flux<Dishs> doingMyJob(){
        return kitchen.getDishes()
                .doOnNext(dishs -> System.out.println(dishs))
                .doOnError(error -> System.out.println(error.getMessage()))
                .doOnComplete(() -> System.out.println("모든 주문이 완료되었다"))
                .map(Dishs::deliver);
    }
}
class Restaurant {
    public void subscribe() {
        AdvancedServer server = new AdvancedServer(new KitchenServices());
        server.doingMyJob().subscribe(
                dishs -> System.out.println(dishs),
                throwable -> System.out.println(throwable)
        );
    }
}
