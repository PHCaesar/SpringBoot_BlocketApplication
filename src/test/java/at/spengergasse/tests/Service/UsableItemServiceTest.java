package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Services.ItemService;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UsableItemServiceTest {


    @Autowired
    private ItemRepository itemRepository;
    private ItemService itemService;

    @BeforeEach
    void setup(){
        assertNotNull(itemRepository);
        itemService = new ItemService(itemRepository);
    }

}
