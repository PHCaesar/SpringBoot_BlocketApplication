package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateNonPlayerCharacterCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.NonPlayerCharacterRepository;
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
public class NonPlayerCharacterRepositoryTest {

    @Autowired
    private NonPlayerCharacterRepository nonPlayerCharacterRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private NonPlayerCharacter nonPlayerCharacter;

    @BeforeEach
    void setup(){
        nonPlayerCharacter = MockUp.mockUpNonPlayerCharacter("Guy",100,new ArrayList<>(),temporalValueFactory.create_datetimestamp(),"");
    }

    @Test
    void ensureNonPlayerCharRepoInsertsCorrectly(){
        nonPlayerCharacterRepository.insert(nonPlayerCharacter);
        assertEquals(nonPlayerCharacterRepository.count(),1);
        assertEquals(nonPlayerCharacterRepository.findByName(nonPlayerCharacter.getName()),nonPlayerCharacter);
        nonPlayerCharacterRepository.findByMutateCommand(MutateNonPlayerCharacterCommand.builder().name(nonPlayerCharacter.getName()).created_at(nonPlayerCharacter.getCreated_at()).health(nonPlayerCharacter.getHealth()).shopItems(nonPlayerCharacter.getShopItems()).token(nonPlayerCharacter.getToken()).build());
    }

    @Test
    void ensureNonPlayerCharacterRepoFindsByMutateCommand(){
        nonPlayerCharacterRepository.insert(nonPlayerCharacter);
        assertEquals(nonPlayerCharacter,nonPlayerCharacterRepository.findByMutateCommand(MutateNonPlayerCharacterCommand.builder().name(nonPlayerCharacter.getName()).created_at(nonPlayerCharacter.getCreated_at()).health(nonPlayerCharacter.getHealth()).shopItems(nonPlayerCharacter.getShopItems()).token(nonPlayerCharacter.getToken()).build()));
    }

    @Test
    void ensureNonPlayerCharacterRepoFindsByName(){
        nonPlayerCharacterRepository.insert(nonPlayerCharacter);
        assertEquals(nonPlayerCharacter,nonPlayerCharacterRepository.findByName(nonPlayerCharacter.getName()));
    }

    @Test
    void ensureNonPlayerCharacterRepoFindsByHealth(){
        nonPlayerCharacterRepository.insert(nonPlayerCharacter);
        assertEquals(nonPlayerCharacter,nonPlayerCharacterRepository.findByHealth(nonPlayerCharacter.getHealth()).get(0));
    }
/*
    @Test
    void ensureNonPlayerCharacterRepoFindsByShopItemsNull(){
        nonPlayerCharacterRepository.insert(nonPlayerCharacter);
        assertEquals(nonPlayerCharacter,nonPlayerCharacterRepository.findByShopItemsNotNull().get(0));
    }
 */
}
