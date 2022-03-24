package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositoryCustom {
    void insert(UsableItem item);

    UsableItem findByItemID(int id);
    UsableItem findByName(String name);
    List<UsableItem> findBySizeAfter(int size);
    List<UsableItem> findBySizeBefore(int size);
}
