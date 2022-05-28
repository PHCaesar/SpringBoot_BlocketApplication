package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.GameUserDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.NanoIdFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.TemporalValueFactory;
import _21224bhifPos1CsesiereiBlocketWiki.Services.TokenService;
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
    @Autowired
    private TokenService tokenService;
    private UserService userService;

    private GameUserDto basicDataUser;


    @BeforeEach
    void setup(){
        assertNotNull(userRepository);
        userService = new UserService(userRepository);
        basicDataUser = mockUpUser(LocalDate.now(),"JM","Josh");
    }


    @Test
    void ensureUserServiceWorksProperlyWithMutateBlockCommand(){
        GameUser addedReference = userService.createInstanceByDTO(basicDataUser);
        assertEquals(basicDataUser.birthDate(), addedReference.getBirthDate());
        assertEquals(basicDataUser.username(), addedReference.getUsername());
        assertEquals(basicDataUser.name(), addedReference.getName());
    }

    @Test
    void ensureUserServiceFindsMutateBlockCommand(){
        GameUserDto user = createUser();
        GameUser addedReference = userService.getUserByName(user);
        assertNotNull(addedReference);
    }

    @Test
    void ensureUserServiceDeletesUser(){
        GameUserDto user = createUser();
        userService.deleteUser(user);
        assertEquals(0,userService.getAllUser().size());
    }

    @Test
    void ensureUserServiceDeletesNonExistentUser(){
        assertThrows(IllegalArgumentException.class,()->userService.deleteUser(basicDataUser));
    }

    @Test
    void ensureUserServiceDeletesAllUsers(){
        createUser();
        userService.insertUser(mockUpUser(LocalDate.now(),"Caesar","Philipp"));
        assertEquals(2,userService.getAllUser().size());
        userService.deleteAll();
        assertEquals(0,userService.getAllUser().size());
    }

    @Test
    void ensureUserServiceInsertsUser(){
        GameUser gu =userService.insertUser(basicDataUser);
        assertEquals(userService.getAllUser().get(0),gu);
    }

    @Test
    void ensureUserServiceDoesntInsertDuplicateUser(){
        GameUser gu =userService.insertUser(basicDataUser);
        assertThrows(IllegalArgumentException.class,()->userService.insertUser(basicDataUser));
    }

    @Test
    void ensureUserServiceUpdatesUser(){
        GameUserDto gdto  =basicDataUser;
        userService.insertUser(gdto);
        gdto = mockUpUser(LocalDate.now(),"JM","Josh");
        GameUser us =userService.updateUser(gdto);
        assertEquals(userService.getAllUser().get(0),us);
    }

    @Test
    void ensureUserServiceUpdatesNonExistentUser(){
        assertThrows(IllegalArgumentException.class,()->userService.updateUser(basicDataUser));
    }

    @Test
    void ensureUserServiceChecksParameterInputUsername(){
        GameUserDto gameUserDto= mockUpUser(LocalDate.now(),"","Hello");
        assertThrows(IllegalArgumentException.class,()->userService.checkParameterInput(gameUserDto));
    }

    @Test
    void ensureUserServiceChecksParameterInputFirstname(){
        GameUserDto gameUserDto= mockUpUser(LocalDate.now(),"Hi","");
        assertThrows(IllegalArgumentException.class,()->userService.checkParameterInput(gameUserDto));
    }


    private GameUserDto mockUpUser(LocalDate birthDate, String username, String firstname){
        return new GameUserDto(new NanoIdFactory().randomNanoId(12),temporalValueFactory.create_datetimestamp(),null,firstname,"",username,birthDate, tokenService.createTokenFor(temporalValueFactory.create_datetimestamp()));
    }

    private GameUserDto createUser(){
        GameUserDto user = basicDataUser;
        userService.createInstanceByDTO(user);
        return user;
    }
}
