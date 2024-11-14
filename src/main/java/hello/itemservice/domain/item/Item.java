package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // Data 가 추가하는 어노테이션 어떤건지 정확히 알고 써야 한다. 실무에서는 메인 도메인에는 안 쓰는 게 좋음.
//@Getter @Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private int quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
