package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.UsableItemDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateItemCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.NanoIdFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.IItemService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
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

        try{
            itemRepository.findByName(item.name());
            throw new IllegalArgumentException("Item "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
        catch (EmptyResultDataAccessException exception){
            UsableItem itemInstance = createInstanceByDTO(item);
            itemInstance.setNanoId(new NanoIdFactory().randomNanoId(16));
            itemRepository.insert(itemInstance);
            return itemInstance;
        }
    }

    // UPDATE
    public UsableItem updateItem(UsableItemDto item){
        checkParameterInput(item);

        try{
            itemRepository.findByName(item.name());
            UsableItem itemInstance = createInstanceByDTO(item);
            itemRepository.delete(itemRepository.findByName(item.name()));
            itemRepository.insert(itemInstance);
            return itemInstance;
        } catch(EmptyResultDataAccessException exception)
        {
            throw new IllegalArgumentException("Item "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    // DELETE
    public void deleteItem(UsableItemDto item){
        checkParameterInput(item);

        try {
            itemRepository.findByName(item.name());
            itemRepository.delete(itemRepository.findByName(item.name()));
        }catch (EmptyResultDataAccessException exception)
        {
            throw new IllegalArgumentException("Block "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
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
        itemInstance.setDescription(item.description());
        itemInstance.setCreated_at(item.created_at());
        itemInstance.setToken(item.token());
        return itemInstance;
    }
}
