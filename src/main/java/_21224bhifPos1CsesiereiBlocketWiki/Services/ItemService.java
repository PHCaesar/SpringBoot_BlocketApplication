package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateItemCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    public final ItemRepository itemRepository;

    // GET
    public UsableItem getItem(MutateItemCommand item){
        checkParameterInput(item);

        var realItem = itemRepository.findByName(item.getName());
        return realItem;
    }

    // CRUD

    // CREATE
    public UsableItem insertItem(MutateItemCommand item){
        checkParameterInput(item);

        if(itemRepository.findByName(item.getName())==null){
            UsableItem itemInstance = createInstanceByMutateCommand(item);
            itemRepository.insert(itemInstance);
            return itemInstance;
        } else throw new IllegalArgumentException("Item "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
    }

    // UPDATE
    public UsableItem updateItem(MutateItemCommand item){
        checkParameterInput(item);

        if(itemRepository.findByName(item.getName())!=null){
            UsableItem itemInstance = createInstanceByMutateCommand(item);
            itemRepository.insert(itemInstance);
            return itemInstance;
        } else throw new IllegalArgumentException("Item "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    // DELETE
    public void deleteItem(MutateItemCommand item){
        checkParameterInput(item);

        if(itemRepository.findByName(item.getName())!=null)
            itemRepository.delete(itemRepository.findByName(item.getName()));
        else throw new IllegalArgumentException("Block "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    public void checkParameterInput(MutateItemCommand item) {
        if (item.getName().isEmpty())
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        if (item.getSize() == 0)
            throw new IllegalArgumentException("Size " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
    }

    public UsableItem createInstanceByMutateCommand(MutateItemCommand item){
        UsableItem itemInstance = new UsableItem();
        itemInstance.setName(item.getName());
        itemInstance.setSize(item.getSize());
        return itemInstance;
    }
}
