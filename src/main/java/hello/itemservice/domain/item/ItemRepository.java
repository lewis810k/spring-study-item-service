package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); // arrayList 에 감싸서 넣으면 store 에 값을 넣어도 arrayList 에는 변화가 없기 때문에 이렇게 사용, 안전하게.
    }

    public void update(Long itemId, Item updateItem) { // Item 은 실무에서는 itemParamDto 를 만드는게 낫다. (id 를 뺀거)
        Item findItem = findById(itemId);
        findItem.setItemName(updateItem.getItemName());
        findItem.setPrice(updateItem.getPrice());
        findItem.setQuantity(updateItem.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}

// 개발할 때 중복이냐 명확성이냐를 따지게 되는 순간이 오면 명확성을 지키는 편이 낫다.
