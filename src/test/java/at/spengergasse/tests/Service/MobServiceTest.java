package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.MobService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.TokenService;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.MobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class MobServiceTest {

    @Autowired
    private MobRepository mobRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;
    @Autowired
    private TokenService tokenService;
    private MobService mobService;

    private MobDto basicDataMob;


    @BeforeEach
    void setup(){
        assertNotNull(mobRepository);
        mobService = new MobService(mobRepository);
        basicDataMob = mockUpMob("Zombie",MobType.AGGRESSIVE);
    }


    @Test
    void ensureMobServiceWorksProperlyWithMutateBlockCommand(){
        Mob addedReference = mobService.createInstanceByDTO(basicDataMob);
        assertEquals(basicDataMob.type(), addedReference.getType());
        assertEquals(basicDataMob.name(), addedReference.getName());
    }

    @Test
    void ensureMobServiceFindsMutateBlockCommand(){
        MobDto mob = basicDataMob;
        mobService.insertMob(mob);
        Mob addedReference = mobService.getMobByName(mob.name());
        assertNotNull(addedReference);
    }

    @Test
    void ensureMobServiceInsertsMob(){
        assertEquals(mobService.getAllMobs().size(),0);
        mobService.insertMob(basicDataMob);
        assertEquals(mobService.getAllMobs().size(),1);
        assertEquals(mobService.getAllMobs().get(0),createMob());
    }

    @Test
    void ensureMobServiceInsertsDuplicateMob(){
        assertEquals(mobService.getAllMobs().size(),0);
        mobService.insertMob(basicDataMob);
        assertThrows(IllegalArgumentException.class,()->mobService.insertMob(basicDataMob));
    }

    @Test
    void ensureMobServiceGetsAllMobsEmpty(){
        assertEquals(mobService.getAllMobs().size(),0);
    }
    @Test
    void ensureMobServiceUpdatesMob(){
        mobService.insertMob(basicDataMob);
        //Change Mob data
        mobService.updateMob(basicDataMob);
        assertEquals(mobService.getAllMobs().size(),1);
    }

    @Test
    void ensureMobServiceUpdatesNonExistentMob(){
        assertThrows(IllegalArgumentException.class,()->mobService.updateMob(basicDataMob));
    }

    @Test
    void ensureMobServiceDeletesMob(){
        mobService.insertMob(basicDataMob);
        assertEquals(mobService.getAllMobs().size(),1);
        mobService.deleteMob(basicDataMob);
        assertEquals(mobService.getAllMobs().size(),0);
    }

    @Test
    void ensureMobServiceDeleteNonExistentMob(){
        assertThrows(IllegalArgumentException.class,()->mobService.deleteMob(basicDataMob));
    }

    @Test
    void ensureMobServiceDeletesAllMobs(){
        mobService.insertMob(basicDataMob);
        mobService.insertMob(mockUpMob("Hainz",MobType.AGGRESSIVE));
        mobService.insertMob(mockUpMob("Unger",MobType.FRIENDLY));

        assertEquals(mobService.getAllMobs().size(),3);
        mobService.deleteAll();
        assertEquals(mobService.getAllMobs().size(),0);
    }

    @Test
    void ensureMobServiceChecksParameterInputName(){
        assertThrows(IllegalArgumentException.class,()->mobService.checkParameterInput(mockUpMob("",MobType.AGGRESSIVE)));
        assertThrows(IllegalArgumentException.class,()->mobService.checkParameterInput(mockUpMob(null,MobType.AGGRESSIVE)));
    }

    @Test
    void ensureMobServiceChecksParameterInputType(){
        assertThrows(IllegalArgumentException.class,()->mobService.checkParameterInput(mockUpMob("sdfsdf",null)));
    }

    private MobDto mockUpMob(String name, MobType type){
        return new MobDto(name,null,type,temporalValueFactory.create_datetimestamp(),tokenService.createTokenFor(temporalValueFactory.create_datetimestamp()));
    }

    private Mob createMob(){
        MobDto mob = basicDataMob;
        return mobService.createInstanceByDTO(mob);
    }
}
