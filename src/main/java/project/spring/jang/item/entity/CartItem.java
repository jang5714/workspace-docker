package project.spring.jang.item.entity;

import lombok.Data;

@Data
public class CartItem {
    private Item item;
    private int quantitiy;

    private CartItem(){}

    CartItem(Item item){
        this.item = item;
        this.quantitiy = 1;
    }


}
