package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.UsableItemDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.TokenService;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.BlockRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import at.spengergasse.tests.MockUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ItemRepositoryTest {


    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private UsableItem baseItemData;

    @BeforeEach
    void Setup(){
        baseItemData=MockUp.mockUpItem(1,"item","",temporalValueFactory.create_datetimestamp(),"");
    }
    @Test
    void assertItemRepoGetsItem(){
        UsableItem item =baseItemData;
        itemRepository.insert(item);
        assertEquals(itemRepository.findByName(item.getName()),item);
    }

    @Test
    void assertItemRepoCreatesItem(){
        UsableItem item =baseItemData;

        assertEquals(itemRepository.count(),0);
        itemRepository.insert(item);
        assertEquals(itemRepository.count(),1);
    }

    @Test
    void assertItemRepoUpdatesItem(){
        Objects.requireNonNull(itemRepository);
        UsableItem item =baseItemData;

        itemRepository.insert(item);
        item.setDescription("HALLO ICH BIN EIN UPDATE!");
        itemRepository.updateItem(item);
        assertEquals(itemRepository.updateItem(item),item);
        assertEquals(itemRepository.findByName(item.getName()).getDescription(),item.getDescription());
    }

    @Test
    void assertItemRepoFindsItemByName(){
        Objects.requireNonNull(itemRepository);
        UsableItem item =baseItemData;
        itemRepository.insert(item);
        assertEquals(itemRepository.findByName(item.getName()),item);
    }

    @Test
    void assertItemRepoRemovesItem() {
        Objects.requireNonNull(itemRepository);

        UsableItem item =baseItemData;

        assertEquals(0,itemRepository.count());
        itemRepository.insert(item);
        assertEquals(1,itemRepository.count());
        itemRepository.delete(item);
        assertEquals(0,itemRepository.count());
    }

    @Test
    void assertItemRepoRemovesAllItems() {
        Objects.requireNonNull(itemRepository);

        UsableItem item =baseItemData;
        itemRepository.insert(item);
        itemRepository.insert(MockUp.mockUpItem(2,"item2","secondMock",temporalValueFactory.create_datetimestamp(),""));
        assertEquals(2,itemRepository.count());
        itemRepository.deleteAll();
        assertEquals(0,itemRepository.count());
    }


    @Test
    void assertItemRepoFindsBySizeBigger(){
        Objects.requireNonNull(itemRepository);

        UsableItem item =baseItemData;
        UsableItem item2 =MockUp.mockUpItem(2,"item2","",temporalValueFactory.create_datetimestamp(),"");
        UsableItem item0 = MockUp.mockUpItem(0,"item0","",temporalValueFactory.create_datetimestamp(),"");

        //insert
        itemRepository.insert(item);
        itemRepository.insert(item2);
        itemRepository.insert(item0);

        List<UsableItem> usableItemList =itemRepository.findBySizeAfter(item.getSize());
        //Proof that size of the list matches correct value
        Assertions.assertEquals(usableItemList.size(),1);
        //Proof of correct value
        Assertions.assertEquals(usableItemList.get(0),item2);

    }

    @Test
    void ensureItemRepoFindsBySizeSmaller(){
        Objects.requireNonNull(itemRepository);

        UsableItem item =baseItemData;
        UsableItem item2 =MockUp.mockUpItem(2,"item2","",temporalValueFactory.create_datetimestamp(),"");
        UsableItem item0 = MockUp.mockUpItem(0,"item0","",temporalValueFactory.create_datetimestamp(),"");

        //insert
        itemRepository.insert(item);
        itemRepository.insert(item2);
        itemRepository.insert(item0);

        List<UsableItem> usableItemList =itemRepository.findBySizeBefore(item.getSize());
        //Proof that size of the list matches correct value
        Assertions.assertEquals(usableItemList.size(),1);
        //Proof of correct value
        Assertions.assertEquals(usableItemList.get(0),item0);
    }

}
