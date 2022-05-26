package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.UserRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepository;
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
public class GameUserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private GameUser user;

    @BeforeEach
    void setup(){
        user= MockUp.mockUpGameUser("CAMERON","JAMES","JCameron",new ArrayList<>(),temporalValueFactory.create_datestamp(),"",temporalValueFactory.create_datetimestamp());
    }

    @Test
    void ensureUserRepositoryInserts(){
        userRepository.insert(user);
        assertEquals(1,userRepository.count());
    }

    @Test
    void ensureUserRepoFindByFirstnameAndUsername(){
        userRepository.insert(user);
        assertEquals(user,userRepository.findByFirstnameAndUsername(user.getFirstname(), user.getUsername()));
    }

    @Test
    void ensureUserRepoFindByDateAfter(){
        userRepository.insert(user);
        assertEquals(1,userRepository.count());
        assertEquals(1,userRepository.findByBirthDateAfter(user.getBirthDate().minusYears(10)).size());
        assertEquals(user,userRepository.findByBirthDateAfter(user.getBirthDate().minusYears(10)).get(0));
    }

    @Test
    void ensureUserRepoFindByDateBefore(){
        userRepository.insert(user);
        assertEquals(1,userRepository.count());
        assertEquals(1,userRepository.findByBirthDateBefore(user.getBirthDate().plusYears(10)).size());
        assertEquals(user,userRepository.findByBirthDateBefore(user.getBirthDate().plusYears(10)).get(0));
    }
}
