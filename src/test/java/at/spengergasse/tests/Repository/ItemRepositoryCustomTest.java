package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepositoryCustom;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepositoryCustomImpl;
import at.spengergasse.tests.MockUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ItemRepositoryCustomTest {

    @Autowired
    private ItemRepositoryCustomImpl itemRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private UsableItem baseItemData;

    @BeforeEach
    void Setup(){
        baseItemData= MockUp.mockUpItem(1,"item","",temporalValueFactory.create_datetimestamp(),"");
    }

    @Test
    void ensureItemRepoFindsBySizeParameterized(){
        Objects.requireNonNull(itemRepository);

        UsableItem item =baseItemData;

        //insert
        itemRepository.insert(item);

        List<UsableItem> usableItemListBigger =itemRepository.findBySizeParameterized(baseItemData.getSize(), true);
        List<UsableItem> usableItemListSmaller = itemRepository.findBySizeParameterized(baseItemData.getSize(), false);
        //Proof that they are not the same
        Assertions.assertEquals(usableItemListBigger,usableItemListSmaller);
    }

}
