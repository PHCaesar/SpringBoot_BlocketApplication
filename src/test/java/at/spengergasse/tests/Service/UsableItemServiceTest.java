package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.UsableItemDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.ItemService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import at.spengergasse.tests.MockUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UsableItemServiceTest {


    @Autowired
    private ItemRepository itemRepository;
    private ItemService itemService;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private UsableItemDto basicItemData;

    @BeforeEach
    void setup(){
        assertNotNull(itemRepository);
        itemService = new ItemService(itemRepository);
        basicItemData = MockUp.mockUpItemDTO("Item",1,temporalValueFactory.create_datetimestamp(),"","");
    }


    @Test
    void ensureItemServiceThrowsExceptionOnInsertingEmptyNamedItem(){
        UsableItemDto item = MockUp.mockUpItemDTO("",1,temporalValueFactory.create_datetimestamp(),"","");
        assertThrows(IllegalArgumentException.class,() ->itemService.insertItem(item));
    }


    @Test
    void ensureItemServiceInsertsItemCorrectly(){
        assertEquals(itemService.itemRepository.count(),0);
        itemService.insertItem(basicItemData);
        assertEquals(itemService.itemRepository.count(),1);
    }

    @Test
    void ensureItemServiceInsertsNoExistingItem(){
        assertEquals(itemService.itemRepository.count(),0);
        itemService.insertItem(basicItemData);
        assertThrows(IllegalArgumentException.class,()->itemService.insertItem(basicItemData));
        assertEquals(itemService.itemRepository.count(),1);
    }

    @Test
    void ensureItemServiceFindsItem(){
        itemService.insertItem(basicItemData);
        assertEquals(itemService.getItem(basicItemData),
                MockUp.mockUpItem(
                        basicItemData.size(),
                        basicItemData.name(),
                        basicItemData.description(),
                        basicItemData.created_at(),
                        basicItemData.token()));
    }




    @Test
    void ensureItemServiceUpdatesCorrectly(){
        UsableItemDto itemDto = basicItemData;
        itemService.insertItem(itemDto);
        itemDto = MockUp.mockUpItemDTO("Item",2,temporalValueFactory.create_datetimestamp(),"","");
        itemService.updateItem(itemDto);
        assertEquals(itemService.itemRepository.count(),1);
        assertEquals(itemService.getItem(itemDto),MockUp.mockUpItem(
                itemDto.size(),
                itemDto.name(),
                itemDto.description(),
                itemDto.created_at(),
                itemDto.token()));
    }


    @Test
    void ensureItemServiceUpdatesNoNonExistingItem(){
        final UsableItemDto itemDto = MockUp.mockUpItemDTO("Item",2,temporalValueFactory.create_datetimestamp(),"","");
        assertThrows(IllegalArgumentException.class,()->itemService.updateItem(itemDto));
        assertEquals(itemService.itemRepository.count(),0);
    }

    @Test
    void ensureItemServiceDeletesCorrectly(){
        UsableItemDto itemDto = basicItemData;
        itemService.insertItem(itemDto);
        itemService.deleteItem(itemDto);
        assertEquals(itemService.itemRepository.count(),0);
    }

    @Test
    void ensureItemServiceDeletesNoNonExistingItem(){
        UsableItemDto itemDto = basicItemData;
        assertThrows(IllegalArgumentException.class , ()->itemService.deleteItem(itemDto));
        assertEquals(itemService.itemRepository.count(),0);
    }

    @Test
    void ensureItemServiceDeletesAllItemsCorrectly(){
        UsableItemDto itemDto = basicItemData;
        itemService.insertItem(itemDto);
        itemDto = MockUp.mockUpItemDTO("Item1",2,temporalValueFactory.create_datetimestamp(),"","");
        itemService.insertItem(itemDto);
        itemService.deleteAll();
        assertEquals(itemService.itemRepository.count(),0);
    }

    @Test
    void ensureItemServiceChecksParameterSize(){
        UsableItemDto itemDto = MockUp.mockUpItemDTO("Item1",0,temporalValueFactory.create_datetimestamp(),"","");
        assertThrows(IllegalArgumentException.class,()->itemService.checkParameterInput(itemDto));
    }

    @Test
    void ensureItemServiceChecksParameterName(){
        UsableItemDto itemDto = MockUp.mockUpItemDTO("",2,temporalValueFactory.create_datetimestamp(),"","");
        assertThrows(IllegalArgumentException.class,()->itemService.checkParameterInput(itemDto));
    }
}
