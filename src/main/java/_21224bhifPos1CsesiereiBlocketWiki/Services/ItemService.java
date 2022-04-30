package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.UsableItemDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateItemCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.IItemService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService implements IItemService {

    public final ItemRepository itemRepository;

    // GET
    public UsableItem getItem(UsableItemDto item){
        checkParameterInput(item);

        var realItem = itemRepository.findByName(item.name());
        return realItem;
    }

    // CRUD

    // CREATE
    public UsableItem insertItem(UsableItemDto item){
        checkParameterInput(item);

        if(itemRepository.findByName(item.name())==null){
            UsableItem itemInstance = createInstanceByDTO(item);
            itemRepository.insert(itemInstance);
            return itemInstance;
        } else throw new IllegalArgumentException("Item "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
    }

    // UPDATE
    public UsableItem updateItem(UsableItemDto item){
        checkParameterInput(item);

        if(itemRepository.findByName(item.name())!=null){
            UsableItem itemInstance = createInstanceByDTO(item);
            itemRepository.insert(itemInstance);
            return itemInstance;
        } else throw new IllegalArgumentException("Item "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    // DELETE
    public void deleteItem(UsableItemDto item){
        checkParameterInput(item);

        if(itemRepository.findByName(item.name())!=null)
            itemRepository.delete(itemRepository.findByName(item.name()));
        else throw new IllegalArgumentException("Block "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }

    public void checkParameterInput(UsableItemDto item) {
        if (item.name().isEmpty())
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        if (item.size() == 0)
            throw new IllegalArgumentException("Size " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
    }

    public UsableItem createInstanceByDTO(UsableItemDto item){
        UsableItem itemInstance = new UsableItem();
        itemInstance.setName(item.name());
        itemInstance.setSize(item.size());
        return itemInstance;
    }
}
