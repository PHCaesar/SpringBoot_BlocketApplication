package at.spengergasse.tests.Controller;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.BlockController;
import at.spengergasse.tests.MockUp;
import org.junit.jupiter.api.BeforeEach;
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
public class BlockControllerTest {

    @Autowired
    private BlockController blockController;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private BlockDto basicBlockData;

    @BeforeEach
    void setup(){
        basicBlockData= MockUp.mockUpBlockDTO(2,"FRANZ","Ferdinant",4,temporalValueFactory.create_datetimestamp());
    }

    @Test
    void ensureBlockControllerGetsBlocks(){
        blockController.postBlocks(basicBlockData);
        assertEquals(blockController.getBlocks().getBody().size(),1);
        assertEquals(blockController.getBlocks().getBody().get(0),Block.builder()
                .blockname(basicBlockData.blockname())
                .size(basicBlockData.size())
                .blockDurability(basicBlockData.blockDurability())
                .created_at(basicBlockData.created_at())
                .name(basicBlockData.name()).build());
    }


    @Test
    void ensureBlockControllerGetsEmptyBlocks(){
        assertEquals(blockController.getBlocks().getBody().size(),0);
    }

    @Test
    void ensureBlockControllerPostsBlocks(){
        assertEquals(blockController.postBlocks(basicBlockData).getBody(),Block.builder()
                .blockname(basicBlockData.blockname())
                .size(basicBlockData.size())
                .blockDurability(basicBlockData.blockDurability())
                .created_at(basicBlockData.created_at())
                .name(basicBlockData.name()).build());
        assertEquals(blockController.getBlocks().getBody().size(),1);
    }

    @Test
    void ensureBlockControllerGetsBlocksByDurability(){
        blockController.postBlocks(basicBlockData);
        blockController.postBlocks(MockUp.mockUpBlockDTO(20,"HEINZ","Hinterseer",5,temporalValueFactory.create_datetimestamp()));
        assertEquals(blockController.getBlocks().getBody().size(),2);
        assertEquals(blockController.getBlocksByDurability(basicBlockData.blockDurability()).getBody().get(0),Block.builder()
                .blockname(basicBlockData.blockname())
                .size(basicBlockData.size())
                .blockDurability(basicBlockData.blockDurability())
                .created_at(basicBlockData.created_at())
                .name(basicBlockData.name()).build());
    }
}
