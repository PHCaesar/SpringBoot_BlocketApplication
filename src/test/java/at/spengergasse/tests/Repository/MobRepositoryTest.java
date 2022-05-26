package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.ItemRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.MobRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepository;
import at.spengergasse.tests.MockUp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class MobRepositoryTest {

    @Autowired
    private MobRepository mobRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    @Autowired
    private ItemRepository itemRepository;

    private Mob mobData;

    @BeforeEach
    void setup(){
        mobData = MockUp.mockUpMob("Zombie",new ArrayList<>(), MobType.AGGRESSIVE,temporalValueFactory.create_datetimestamp(),"");
    }
    @Test
    void ensureThatMobRepoInsertsCorrectly(){
        mobRepository.insert(mobData);
        assertEquals(1,mobRepository.count());
        assertEquals(mobData,mobRepository.findAll().get(0));
    }

    @Test
    void ensureThatMobRepoFindsByName(){
        mobRepository.insert(mobData);
        assertEquals(1,mobRepository.count());
        assertEquals(mobData,mobRepository.findByName(mobData.getName()));
    }

    @Test
    void ensureThatMobRepoFindsByDTO(){
        mobRepository.insert(mobData);
        assertEquals(1,mobRepository.count());
        assertEquals(mobData,mobRepository.findByDTO(new MobDto(mobData)));
    }
/*
    @Test
    void ensureThatMobRepoFindsByDrops(){
        List<UsableItem> drops = new ArrayList<>();

        drops.add(MockUp.mockUpItem(1,"Item","Item",temporalValueFactory.create_datetimestamp(),"Noice"));
        //drops.stream().forEach((current) -> itemRepository.insert(current));
        Mob m = MockUp.mockUpMob("Zombie",drops, MobType.AGGRESSIVE,temporalValueFactory.create_datetimestamp(),"Noice");
        mobRepository.insert(m);
        assertEquals(1,mobRepository.count());
        List<Mob> mobs =mobRepository.findByDrops(drops);
        assertEquals(mobs.size(),1);
    }
*/

    @Test
    void ensureThatMobRepoFindByType(){
        Mob m = mobData;
        m.setType(MobType.FRIENDLY);
        mobRepository.insert(mobData);
        mobRepository.insert(m);
        assertEquals(mobRepository.findByType(MobType.FRIENDLY).get(0),m);
    }


}
