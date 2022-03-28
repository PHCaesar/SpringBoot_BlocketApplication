package at.spengergasse.tests;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateSurnameCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.SurnameService;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.SurnameRepository;
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
public class SurnameServiceTest {

    @Autowired
    private SurnameRepository surnameRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;
    private SurnameService surnameService;


    private MutateSurnameCommand basicDataSurname;


    @BeforeEach
    void setup(){
        assertNotNull(surnameRepository);
        surnameService = new SurnameService(surnameRepository);
        basicDataSurname = mockUpSurname("JAMIE");
    }


    @Test
    void ensureUserServiceWorksProperlyWithMutateBlockCommand(){
        Surname addedReference = surnameService.createInstanceByMutateCommand(basicDataSurname);
        assertEquals(basicDataSurname.getName(), addedReference.getName());
    }

    @Test
    void ensureUserServiceFindsMutateBlockCommand(){
        MutateSurnameCommand surname = createSurname();
        Surname addedReference = surnameService.getByName(surname);
        assertNotNull(addedReference);
    }

    @Test
    void ensureMobServiceDeletesMob(){
        MutateSurnameCommand surname = createSurname();
        surnameService.deleteSurname(surname);
        assertThrows(EmptyResultDataAccessException.class, () -> surnameService.getByName(surname));
    }

    private MutateSurnameCommand mockUpSurname(String name){
        return MutateSurnameCommand.builder()
                .name(name)
                .created_at(temporalValueFactory.create_timestamp())
                .build();
    }

    private MutateSurnameCommand createSurname(){
        MutateSurnameCommand surname = basicDataSurname;
        surnameService.createInstanceByMutateCommand(surname);
        return surname;
    }
}
