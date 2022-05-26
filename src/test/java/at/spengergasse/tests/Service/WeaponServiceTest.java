package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.WeaponDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.WeaponService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepository;
import at.spengergasse.tests.MockUp;
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
public class WeaponServiceTest {

    @Autowired
    private WeaponRepository weaponRepository;
    private WeaponService weaponService;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private WeaponDto basicWeaponData;

    @BeforeEach
    void setup(){
        weaponService = new WeaponService(weaponRepository);
        basicWeaponData = MockUp.mockUpWeaponDTO(1,"Sword", WeaponClass.MAGE,"Cut",temporalValueFactory.create_datetimestamp(),"");
    }

    @Test
    void ensureWeaponRepoInsertsWeaponCorrectly(){
        assertEquals(weaponService.weaponRepository.count(),0);
        weaponService.insertWeapon(basicWeaponData);
        assertEquals(weaponService.weaponRepository.count(),1);
    }

    @Test
    void ensureWeaponRepoInsertsNoNoDuplicateWeaponsCorrectly(){
        assertEquals(weaponService.weaponRepository.count(),0);
        weaponService.insertWeapon(basicWeaponData);
        assertThrows(IllegalArgumentException.class, () -> weaponService.insertWeapon(basicWeaponData));
    }


    @Test
    void ensureWeaponRepoRemovesWeaponCorrectly(){
        assertEquals(weaponService.weaponRepository.count(),0);
        weaponService.insertWeapon(basicWeaponData);
        assertEquals(weaponService.weaponRepository.count(),1);
        weaponService.deleteWeapon(basicWeaponData);
        assertEquals(weaponService.weaponRepository.count(),0);
    }

    @Test
    void ensureWeaponRepoRemovesNonExistentWeapon(){
        assertEquals(weaponService.weaponRepository.count(),0);
        assertThrows(IllegalArgumentException.class,()->weaponService.deleteWeapon(basicWeaponData));
    }


    @Test
    void ensureWeaponRepoRemovesAllWeaponsCorrectly(){
        assertEquals(weaponService.weaponRepository.count(),0);
        weaponService.insertWeapon(basicWeaponData);
        weaponService.insertWeapon(MockUp.mockUpWeaponDTO(2,"Nice", WeaponClass.RANGED,"Pog",temporalValueFactory.create_datetimestamp(),""));
        assertEquals(weaponService.weaponRepository.count(),2);
        weaponService.deleteAll();
        assertEquals(weaponService.weaponRepository.count(),0);
    }

    @Test
    void ensureWeaponRepoUpdatesWeaponCorrectly(){
        WeaponDto wdto =basicWeaponData;
        assertEquals(weaponService.weaponRepository.count(),0);
        weaponService.insertWeapon(wdto);
        assertEquals(weaponService.weaponRepository.count(),1);
        wdto = MockUp.mockUpWeaponDTO(5,"Sword", WeaponClass.MELEE,"Cut",temporalValueFactory.create_datetimestamp(),"");
        weaponService.updateWeapon(wdto);
        assertEquals(weaponService.weaponRepository.count(),1);
    }


    @Test
    void ensureWeaponRepoUpdatesNonExistentWeapon(){
        WeaponDto wdto =basicWeaponData;
        assertEquals(weaponService.weaponRepository.count(),0);
        assertThrows(IllegalArgumentException.class,()->weaponService.updateWeapon(wdto));
    }


    @Test
    void ensureWeaponRepoGetsByName(){
        assertEquals(weaponService.weaponRepository.count(),0);
        weaponService.insertWeapon(basicWeaponData);
        assertEquals(weaponService.weaponRepository.count(),1);
        assertEquals(weaponService.getByName(basicWeaponData.name()).getName(),basicWeaponData.name());
        assertEquals(weaponService.getByName(basicWeaponData.name()).getClassification(),basicWeaponData.classification());
        assertEquals(weaponService.getByName(basicWeaponData.name()).getDamage(),basicWeaponData.damage());
        assertEquals(weaponService.getByName(basicWeaponData.name()).getDescription(),basicWeaponData.description());
    }


    @Test
    void ensureWeaponRepoChecksParameterInputCorrectly(){
        assertDoesNotThrow(()-> weaponService.checkParameterInput(basicWeaponData));
    }

    @Test
    void ensureWeaponRepoChecksWrongNamedParameterInputCorrectly(){
        assertThrows(IllegalArgumentException.class,()-> weaponService.checkParameterInput( MockUp.mockUpWeaponDTO(1,"", WeaponClass.MAGE,"Cut",temporalValueFactory.create_datetimestamp(),"")));
        assertThrows(IllegalArgumentException.class,()-> weaponService.checkParameterInput( MockUp.mockUpWeaponDTO(1,null, WeaponClass.MAGE,"Cut",temporalValueFactory.create_datetimestamp(),"")));
    }


    @Test
    void ensureWeaponRepoChecksWrongDescribedParameterInputCorrectly(){
        assertThrows(IllegalArgumentException.class,()-> weaponService.checkParameterInput( MockUp.mockUpWeaponDTO(1,"sdhjf", WeaponClass.MAGE,"",temporalValueFactory.create_datetimestamp(),"")));
        assertThrows(IllegalArgumentException.class,()-> weaponService.checkParameterInput( MockUp.mockUpWeaponDTO(1,"sdhjf", WeaponClass.MAGE,null,temporalValueFactory.create_datetimestamp(),"")));
    }

    @Test
    void ensureWeaponRepoChecksWrongClassedParameterInputCorrectly(){
        assertThrows(IllegalArgumentException.class,()-> weaponService.checkParameterInput( MockUp.mockUpWeaponDTO(1,"sdhjf", null,"sdf",temporalValueFactory.create_datetimestamp(),"")));
    }


    @Test
    void ensureWeaponRepoChecksWrongDamagedParameterInputCorrectly(){
        assertThrows(IllegalArgumentException.class,()-> weaponService.checkParameterInput( MockUp.mockUpWeaponDTO(0,"sdhjf", WeaponClass.MAGE,"dsf",temporalValueFactory.create_datetimestamp(),"")));
    }


    @Test
    void ensureWeaponRepoCreatesWeaponByDTOCorrectly(){
        Weapon w = weaponService.createInstanceByDto(basicWeaponData);
        assertEquals(weaponService.weaponRepository.count(),1);
        assertEquals(w.getName(),basicWeaponData.name());
        assertEquals(w.getDamage(),basicWeaponData.damage());
        assertEquals(w.getClassification(),basicWeaponData.classification());
        assertEquals(w.getDescription(),basicWeaponData.description());
    }


}
