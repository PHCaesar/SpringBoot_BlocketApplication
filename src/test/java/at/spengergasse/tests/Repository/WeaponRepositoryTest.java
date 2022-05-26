package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepositoryCustom;
import at.spengergasse.tests.MockUp;
import org.junit.jupiter.api.BeforeAll;
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
public class WeaponRepositoryTest {

    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private Weapon baseWeaponData;

    @BeforeEach
    void setup(){
        baseWeaponData = MockUp.mockUpWeapon(5,"Sword", WeaponClass.MELEE,"Cuts through everything",temporalValueFactory.create_datetimestamp(),"");
    }

    @Test
    void ensureWeaponRepoFindsByName(){
        weaponRepository.insert(baseWeaponData);
        assertEquals(weaponRepository.findByName(baseWeaponData.getName()),baseWeaponData);

    }

    @Test
    void ensureWeaponRepoFindsByClassification(){

        weaponRepository.insert(baseWeaponData);
        weaponRepository.insert(MockUp.mockUpWeapon(5,"Sword", WeaponClass.MAGE,"Cuts through everything",temporalValueFactory.create_datetimestamp(),""));

        assertEquals(weaponRepository.count(),2);
        assertEquals(weaponRepository.findByClassification(baseWeaponData.getClassification()).size(),1);
        assertEquals(weaponRepository.findByClassification(baseWeaponData.getClassification()).get(0),baseWeaponData);
    }


    @Test
    void ensureWeaponRepoFindsByDamageLower(){
        Weapon w =MockUp.mockUpWeapon(3,"Sword", WeaponClass.MAGE,"Cuts through everything",temporalValueFactory.create_datetimestamp(),"");
        Weapon w1 = MockUp.mockUpWeapon(10,"Sword", WeaponClass.MAGE,"Cuts through everything",temporalValueFactory.create_datetimestamp(),"");
        weaponRepository.insert(baseWeaponData);
        weaponRepository.insert(w);
        weaponRepository.insert(w1);


        assertEquals(weaponRepository.count(),3);
        assertEquals(weaponRepository.findByDamageLower(w1.getDamage()).size(),2);
    }

    @Test
    void ensureWeaponRepoFindsByDamageHigher(){

        Weapon w =MockUp.mockUpWeapon(3,"Sword", WeaponClass.MAGE,"Cuts through everything",temporalValueFactory.create_datetimestamp(),"");
        Weapon w1 = MockUp.mockUpWeapon(10,"Sword", WeaponClass.MAGE,"Cuts through everything",temporalValueFactory.create_datetimestamp(),"");
        weaponRepository.insert(baseWeaponData);
        weaponRepository.insert(w);
        weaponRepository.insert(w1);


        assertEquals(weaponRepository.count(),3);
        assertEquals(weaponRepository.findByDamageHigher(w.getDamage()).size(),2);
    }

    @Test
    void ensureWeaponRepoRemovesWeapon(){
        Weapon w =MockUp.mockUpWeapon(10,"Sword", WeaponClass.MAGE,"Cuts through everything",temporalValueFactory.create_datetimestamp(),"");
        weaponRepository.insert(w);
        assertEquals(weaponRepository.count(),1);
        weaponRepository.deleteAll();
        assertEquals(weaponRepository.count(),0);
    }

}
