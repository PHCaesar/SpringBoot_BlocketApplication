package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.SurnameRepository;
import at.spengergasse.tests.MockUp;
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
public class SurnameRepositoryTest {

    @Autowired
    private SurnameRepository surnameRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private Surname surname;

    @BeforeEach
    void setup(){
        surname= MockUp.mockUpSurname("Jeff","",temporalValueFactory.create_datetimestamp());
    }

    @Test
    void ensureSurnameRepositoryInsertsCorrectly(){
        surnameRepository.insert(surname);
        assertEquals(1,surnameRepository.count());
    }

    @Test
    void ensureSurnameRepoFindsByName(){
        surnameRepository.insert(surname);
        assertEquals(surnameRepository.findByName(surname.getName()),surname);
    }

    @Test
    void ensureSurnameRepoDelete(){
        surnameRepository.insert(surname);
        surnameRepository.delete(surname);
        assertEquals(0,surnameRepository.count());
    }

}
