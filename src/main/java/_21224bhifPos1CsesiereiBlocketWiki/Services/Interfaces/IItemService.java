package _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.UsableItemDto;

public interface IItemService {
    public UsableItem insertItem(UsableItemDto item);
    public UsableItem getItem(UsableItemDto item);
    public UsableItem updateItem(UsableItemDto item);
    public void deleteItem(UsableItemDto item);
    public void deleteAll();

}
