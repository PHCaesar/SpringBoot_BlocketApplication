package at.spengergasse.tests;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateNonPlayerCharacterCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.NonPlayerCharacterService;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.NonPlayerCharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class NonPlayerCharacterServiceTest {

    @Autowired
    private NonPlayerCharacterRepository nonPlayerCharacterRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;
    private NonPlayerCharacterService nonPlayerCharacterService;

    private MutateNonPlayerCharacterCommand basicDataNonPlayerCharacter;


    @BeforeEach
    void setup(){
        assertNotNull(nonPlayerCharacterRepository);
        nonPlayerCharacterService = new NonPlayerCharacterService(nonPlayerCharacterRepository);
        basicDataNonPlayerCharacter = mockUpNonPlayerCharacter("JAMIE", 12f);
    }


    @Test
    void ensureUserServiceWorksProperlyWithMutateBlockCommand(){
        NonPlayerCharacter addedReference = nonPlayerCharacterService.createInstanceByMutateCommand(basicDataNonPlayerCharacter);
        assertEquals(basicDataNonPlayerCharacter.getHealth(), addedReference.getHealth());
        assertEquals(basicDataNonPlayerCharacter.getName(), addedReference.getName());
    }

    @Test
    void ensureUserServiceFindsMutateBlockCommand(){
        MutateNonPlayerCharacterCommand mob = createNonPlayerCharacter();
        NonPlayerCharacter addedReference = nonPlayerCharacterService.getNonPlayerCharacterByName(mob);
        assertNotNull(addedReference);
    }

    @Test
    void ensureMobServiceDeletesMob(){
        MutateNonPlayerCharacterCommand mob = createNonPlayerCharacter();
        nonPlayerCharacterService.deleteNonPlayerCharacter(mob);
        assertThrows(EmptyResultDataAccessException.class, () -> nonPlayerCharacterService.getNonPlayerCharacterByName(mob));
    }

    private MutateNonPlayerCharacterCommand mockUpNonPlayerCharacter(String name, float health){
        return MutateNonPlayerCharacterCommand.builder()
                .name(name)
                .health(health)
                .created_at(temporalValueFactory.create_timestamp())
                .build();
    }

    private MutateNonPlayerCharacterCommand createNonPlayerCharacter(){
        MutateNonPlayerCharacterCommand mob = basicDataNonPlayerCharacter;
        nonPlayerCharacterService.createInstanceByMutateCommand(mob);
        return mob;
    }
}
