package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.BlockRepository;
import at.spengergasse.tests.MockUp;
import org.apache.logging.log4j.core.util.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class BlockRepositoryTest {

    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;



    @Test
    public void ensureRepositoryListAllisNullonEmpty(){
        Assert.isEmpty(blockRepository.ListAll());
    }

    @Test
    public void ensureRepositoryAddsBlockInstance(){
        Block block = MockUp.mockUpBlock("Franz",2,"Ferdinant",4,temporalValueFactory.create_datetimestamp(),"");
        blockRepository.insert(block);
        assertEquals(block,blockRepository.findByDTO(new BlockDto(block)));
    }

    @Test
    public void ensureRepositoryRemovesBlockInstance(){
        Block block = MockUp.mockUpBlock("Franz",2,"Ferdinant",4,temporalValueFactory.create_datetimestamp(),"");
        blockRepository.insert(block);
        assertEquals(block,blockRepository.findByDTO(new BlockDto(block)));
        blockRepository.deleteBlock(block);
        Assert.isEmpty(blockRepository.ListAll());
    }

    @Test
    public void ensureRepositoryDetectsDuplicateData(){
        Block block = MockUp.mockUpBlock("Franz",2,"Ferdinant",4,temporalValueFactory.create_datetimestamp(),"");
        blockRepository.insert(block);
        blockRepository.insert(block);
        assertEquals(1,blockRepository.findAll().size());
    }
}
