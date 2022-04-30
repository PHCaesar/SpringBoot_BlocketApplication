package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.NonPlayerCharacterDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateNonPlayerCharacterCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.NonPlayerCharacterService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.TokenService;
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
    @Autowired
    private TokenService tokenService;

    private NonPlayerCharacterService nonPlayerCharacterService;

    private NonPlayerCharacterDto basicDataNonPlayerCharacter;


    @BeforeEach
    void setup(){
        assertNotNull(nonPlayerCharacterRepository);
        nonPlayerCharacterService = new NonPlayerCharacterService(nonPlayerCharacterRepository);
        basicDataNonPlayerCharacter = mockUpNonPlayerCharacter("JAMIE", 12f);
    }


    @Test
    void ensureUserServiceWorksProperlyWithMutateBlockCommand(){
        NonPlayerCharacter addedReference = nonPlayerCharacterService.createInstanceByDTO(basicDataNonPlayerCharacter);
        assertEquals(basicDataNonPlayerCharacter.health(), addedReference.getHealth());
        assertEquals(basicDataNonPlayerCharacter.name(), addedReference.getName());
    }

    @Test
    void ensureUserServiceFindsMutateBlockCommand(){
        NonPlayerCharacterDto mob = createNonPlayerCharacter();
        NonPlayerCharacter addedReference = nonPlayerCharacterService.getNonPlayerCharacterByName(mob.name());
        assertNotNull(addedReference);
    }

    @Test
    void ensureMobServiceDeletesMob(){
        NonPlayerCharacterDto mob = createNonPlayerCharacter();
        nonPlayerCharacterService.deleteNonPlayerCharacter(mob);
        assertThrows(EmptyResultDataAccessException.class, () -> nonPlayerCharacterService.getNonPlayerCharacterByName(mob.name()));
    }

    private NonPlayerCharacterDto mockUpNonPlayerCharacter(String name, float health){
        return new NonPlayerCharacterDto(name,health,null,temporalValueFactory.create_datetimestamp(),tokenService.createTokenFor(temporalValueFactory.create_datetimestamp()));
    }

    private NonPlayerCharacterDto createNonPlayerCharacter(){
        NonPlayerCharacterDto mob = basicDataNonPlayerCharacter;
        nonPlayerCharacterService.createInstanceByDTO(mob);
        return mob;
    }
}
