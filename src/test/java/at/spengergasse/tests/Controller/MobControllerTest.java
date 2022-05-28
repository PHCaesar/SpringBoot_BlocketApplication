package at.spengergasse.tests.Controller;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.api.MobController;
import at.spengergasse.tests.MockUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class MobControllerTest {

    @Autowired
    private MobController mobController;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private Mob mobData;

    @BeforeEach
    void setup(){
        mobData = MockUp.mockUpMob("Zombie",new ArrayList<>(), MobType.AGGRESSIVE,temporalValueFactory.create_datetimestamp(),"");
    }

    @Test
    void ensureMobControllerGetsMobsEmpty(){
        assertEquals(mobController.getMobs().getBody().isEmpty(),true);
    }

    @Test
    void ensureMobControllerPostsMobs(){
        Mob m =mobController.postBlocks(MutateMobCommand.builder()
                .name(mobData.getName())
                .drops(mobData.getDrops())
                .type(mobData.getType())
                .build()).getBody();
        assertEquals(m.getName(),mobData.getName());
        assertEquals(m.getType(),mobData.getType());
        assertEquals(mobController.getMobs().getBody().size(),1);
    }

    @Test
    void ensureMobControllerGetsMobByName(){
        Mob m =mobController.postBlocks(MutateMobCommand.builder()
                .name(mobData.getName())
                .drops(mobData.getDrops())
                .type(mobData.getType())
                .build()).getBody();
        assertEquals(m.getName(),mobData.getName());
        assertEquals(m.getType(),mobData.getType());
        Mob mob = mobController.getMobsByNames(mobData.getName()).getBody();
        assertEquals(mob.getType(),mobData.getType());
        assertEquals(mob.getName(),mobData.getName());
    }


}
