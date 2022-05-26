package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.UsableItemDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositoryCustom {
    void insert(UsableItem item);

    UsableItem findByItemID(long id);
    UsableItem findByName(String name);
    List<UsableItem> findBySizeAfter(int size);
    List<UsableItem> findBySizeBefore(int size);
    UsableItem updateItem(UsableItem item);
}
