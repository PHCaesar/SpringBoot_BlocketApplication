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
    void ensureUserServiceWorksProperlyWithMutateBlockCommand(){
        Mob addedReference = mobService.createInstanceByDTO(basicDataMob);
        assertEquals(basicDataMob.type(), addedReference.getType());
        assertEquals(basicDataMob.name(), addedReference.getName());
    }

    @Test
    void ensureUserServiceFindsMutateBlockCommand(){
        MobDto mob = createMob();
        Mob addedReference = mobService.getMobByName(mob.name());
        assertNotNull(addedReference);
    }
    private MobDto mockUpMob(String name, MobType type){
        return new MobDto(name,null,type,temporalValueFactory.create_datetimestamp(),tokenService.createTokenFor(temporalValueFactory.create_datetimestamp()));
    }

    private MobDto createMob(){
        MobDto mob = basicDataMob;
        mobService.createInstanceByDTO(mob);
        return mob;
    }
}
