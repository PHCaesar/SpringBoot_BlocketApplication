package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositoryCustom {
    void insert(Item item);

    Item findByItemID(int id);
    Item findByName(String name);
    List<Item> findBySizeAfter(int size);
    List<Item> findBySizeBefore(int size);
}
