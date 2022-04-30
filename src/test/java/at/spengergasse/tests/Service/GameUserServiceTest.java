package at.spengergasse.tests.Service;

import _21224bhifPos1CsesiereiBlocketWiki.Application;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.GameUserDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
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
        assertThrows(EmptyResultDataAccessException.class, () -> userService.getUserByName(user));
    }


    private GameUserDto mockUpUser(LocalDate birthDate, String username, String firstname){
        return new GameUserDto(temporalValueFactory.create_datetimestamp(),null,firstname,"",username,birthDate, tokenService.createTokenFor(temporalValueFactory.create_datetimestamp()));
    }

    private GameUserDto createUser(){
        GameUserDto user = basicDataUser;
        userService.createInstanceByDTO(user);
        return user;
    }
}
