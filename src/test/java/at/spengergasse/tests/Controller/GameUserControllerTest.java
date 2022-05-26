package at.spengergasse.tests.Controller;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.presentation.controller.GameUserController;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class GameUserControllerTest {

    @Autowired
    private GameUserController userController;
    @Autowired
    private TemporalValueFactory temporalValueFactory;

    private GameUser basicDataUser;

    @BeforeEach
    void setup(){
        basicDataUser= MockUp.mockUpGameUser("CAMERON","JAMES","JCameron",new ArrayList<>(),temporalValueFactory.create_datestamp(),"",temporalValueFactory.create_datetimestamp());
    }

    @Test
    void ensureGameUserControllerGetsUsersEmpty(){
        assertEquals(userController.getUsers().getBody().size(),0);
    }


    @Test
    void ensureGameUserControllerPostUser(){
        GameUser postetUser = userController.postUsers(MutateUserCommand.builder()
                .name(basicDataUser.getName())
                .birthDate(basicDataUser.getBirthDate())
                .username(basicDataUser.getUsername())
                .firstname(basicDataUser.getFirstname())
                .created_at(basicDataUser.getCreated_at())
                .surnames(basicDataUser.getSurnames())
                .token(basicDataUser.getToken()).build()).getBody();

        assertEquals(postetUser.getName(),basicDataUser.getName());
        assertEquals(postetUser.getUsername(),basicDataUser.getUsername());
        assertEquals(postetUser.getBirthDate(),basicDataUser.getBirthDate());
        assertEquals(postetUser.getFirstname(),basicDataUser.getFirstname());
    }

    @Test
    void ensureGameUserControllerPostUserOverwritesCreationDateAndToken(){
        GameUser postetUser = userController.postUsers(MutateUserCommand.builder()
                .name(basicDataUser.getName())
                .birthDate(basicDataUser.getBirthDate())
                .username(basicDataUser.getUsername())
                .firstname(basicDataUser.getFirstname())
                .created_at(basicDataUser.getCreated_at())
                .surnames(basicDataUser.getSurnames())
                .token(basicDataUser.getToken()).build()).getBody();

        assertNotEquals(postetUser.getToken(),basicDataUser.getToken());
        //assertNotEquals(postetUser.getCreated_at(),basicDataUser.getCreated_at());
    }

    @Test
    void ensureGameUserControllerGetsUsers(){
        GameUser postetUser = userController.postUsers(MutateUserCommand.builder()
                .name(basicDataUser.getName())
                .birthDate(basicDataUser.getBirthDate())
                .username(basicDataUser.getUsername())
                .firstname(basicDataUser.getFirstname())
                .created_at(basicDataUser.getCreated_at())
                .surnames(basicDataUser.getSurnames())
                .token(basicDataUser.getToken()).build()).getBody();
        assertEquals(postetUser,userController.getUsers().getBody().get(0));
        assertEquals(1,userController.getUsers().getBody().size());
    }

    @Test
    void ensureGameUserControllerGetsUsersByNames(){
        GameUser postetUser = userController.postUsers(MutateUserCommand.builder()
                .name(basicDataUser.getName())
                .birthDate(basicDataUser.getBirthDate())
                .username(basicDataUser.getUsername())
                .firstname(basicDataUser.getFirstname())
                .created_at(basicDataUser.getCreated_at())
                .surnames(basicDataUser.getSurnames())
                .token(basicDataUser.getToken()).build()).getBody();

        assertEquals(postetUser,userController.getUserByNames(postetUser.getFirstname(),postetUser.getName(),postetUser.getUsername()).getBody());
    }
}
