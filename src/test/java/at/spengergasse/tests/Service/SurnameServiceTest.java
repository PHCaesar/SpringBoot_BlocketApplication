package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.SurnameDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateSurnameCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.NanoIdFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
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

    private SurnameDto basicDataSurname;


    @BeforeEach
    void setup(){
        assertNotNull(surnameRepository);
        surnameService = new SurnameService(surnameRepository);
        basicDataSurname = mockUpSurname("JAMIE");
    }


    @Test
    void ensureSurnameServiceWorksProperlyWithMutateSurnameCommand(){
        Surname addedReference = surnameService.createInstanceByDTO(basicDataSurname);
        assertEquals(basicDataSurname.name(), addedReference.getName());
    }

    @Test
    void ensureSurnameServiceFindsMutateSurnameCommand(){
        SurnameDto surname = createSurname();
        Surname addedReference = surnameService.getByName(surname.name());
        assertNotNull(addedReference);
    }

    @Test
    void ensureSurnameServiceDeletesCorrectly(){
        SurnameDto surname = createSurname();
        surnameService.deleteSurname(surname);
        assertEquals(surnameRepository.count(),0);
    }

    @Test
    void ensureSurnameServiceDeletesNonExistent(){
        assertThrows(IllegalArgumentException.class, () ->surnameService.deleteSurname(basicDataSurname));
    }

    @Test
    void ensureSurnameServiceDeletesAll(){
        surnameService.insertSurname(mockUpSurname("surname"));
        SurnameDto surname = createSurname();
        assertEquals(surnameRepository.count(),2);
        surnameService.deleteAll();
        assertEquals(surnameRepository.count(),0);
    }

    @Test
    void ensureSurnameServiceInsertsCorrectly(){
        surnameService.insertSurname(basicDataSurname);
        assertEquals(surnameRepository.count(),1);
    }

    @Test
    void ensureSurnameServiceInsertsNoDuplicateData(){
        surnameService.insertSurname(basicDataSurname);
        assertThrows(IllegalArgumentException.class,()->surnameService.insertSurname(basicDataSurname));
    }

    @Test
    void ensureSurnameServiceUpdatesSurname(){
        surnameService.insertSurname(basicDataSurname);
        surnameService.updateSurname(basicDataSurname);
        assertEquals(surnameRepository.count(),1);
    }

    @Test
    void ensureSurnameServiceUpdatesNonExistingSurname(){
        assertThrows(IllegalArgumentException.class,()->surnameService.updateSurname(basicDataSurname));
    }

    private SurnameDto mockUpSurname(String name){
        return new SurnameDto(new NanoIdFactory().randomNanoId(12),name,temporalValueFactory.create_datetimestamp());
    }

    private SurnameDto createSurname(){
        SurnameDto surname = basicDataSurname;
        surnameService.createInstanceByDTO(surname);
        return surname;
    }
}
