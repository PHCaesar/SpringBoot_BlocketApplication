package at.spengergasse.tests.Repository;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameContent;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.GameContentRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.UserRepository;
import at.spengergasse.tests.MockUp;
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
public class GameContentRepositoryTest {

    @Autowired
    private GameContentRepository gameContentRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TemporalValueFactory temporalValueFactory;

    @Test
    void ensureGameContentRepoInsertsCorrectly(){
        GameUser user= MockUp.mockUpGameUser("CAMERON","JAMES","JCameron",new ArrayList<>(),temporalValueFactory.create_datestamp(),"",temporalValueFactory.create_datetimestamp());
        userRepository.insert(user);
        GameContent gc =MockUp.mockUpGameContent(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),user,new ArrayList<>(),"",temporalValueFactory.create_datetimestamp());
        gameContentRepository.insert(gc);
        assertEquals(gameContentRepository.findAll().size(),1);
        assertEquals(gameContentRepository.findAll().get(0),gc);
    }

    @Test
    void ensureGameContentRepoGetsByUser(){
        GameUser user= MockUp.mockUpGameUser("CAMERON","JAMES","JCameron",new ArrayList<>(),temporalValueFactory.create_datestamp(),"",temporalValueFactory.create_datetimestamp());
        userRepository.insert(user);
        GameContent gc =MockUp.mockUpGameContent(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),user,new ArrayList<>(),"",temporalValueFactory.create_datetimestamp());
        gameContentRepository.insert(gc);
        assertEquals(gameContentRepository.findAll().size(),1);
        assertEquals(gameContentRepository.findByUser(user),gc);
    }
}
