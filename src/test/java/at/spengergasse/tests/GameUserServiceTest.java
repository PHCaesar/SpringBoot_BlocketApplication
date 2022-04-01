package at.spengergasse.tests;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.UserService;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class GameUserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TemporalValueFactory temporalValueFactory;
    private UserService userService;

    private MutateUserCommand basicDataUser;


    @BeforeEach
    void setup(){
        assertNotNull(userRepository);
        userService = new UserService(userRepository);
        basicDataUser = mockUpUser(LocalDate.now(),"JM","Josh");
    }


    @Test
    void ensureUserServiceWorksProperlyWithMutateBlockCommand(){
        GameUser addedReference = userService.createInstanceByMutateCommand(basicDataUser);
        assertEquals(basicDataUser.getBirthDate(), addedReference.getBirthDate());
        assertEquals(basicDataUser.getUsername(), addedReference.getUsername());
        assertEquals(basicDataUser.getName(), addedReference.getName());
    }

    @Test
    void ensureUserServiceFindsMutateBlockCommand(){
        MutateUserCommand user = createUser();
        GameUser addedReference = userService.getUserByName(user);
        assertNotNull(addedReference);
    }

    @Test
    void ensureUserServiceDeletesUser(){
        MutateUserCommand user = createUser();
        userService.deleteUser(user);
        assertThrows(EmptyResultDataAccessException.class, () -> userService.getUserByName(user));
    }


    private MutateUserCommand mockUpUser(LocalDate birthDate, String username, String firstname){
        return MutateUserCommand.builder()
                .username(username)
                .birthDate(birthDate)
                .firstname(firstname)
                .created_at(temporalValueFactory.create_timestamp())
                .build();
    }

    private MutateUserCommand createUser(){
        MutateUserCommand user = basicDataUser;
        userService.createInstanceByMutateCommand(user);
        return user;
    }
}
