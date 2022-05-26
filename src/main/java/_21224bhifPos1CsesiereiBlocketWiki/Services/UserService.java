package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.GameUserDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.IUserService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class UserService implements IUserService {

    public final UserRepository userRepository;

    // GET
    public GameUser getUserByName(GameUserDto user){
        checkParameterInput(user);

        var realUser = userRepository.findByFirstnameAndUsername(user.firstname() ,user.username());
        log.info("Found {} realUser", realUser);
        return realUser;
    }

    public List<GameUser> getAllUser()
    {
        return userRepository.findAll();
    }

    // CREATE
    public GameUser insertUser(GameUserDto user){
        checkParameterInput(user);
        if(userRepository.findByFirstnameAndUsername(user.firstname() ,user.username())==null){
            GameUser userInstance = createInstanceByDTO(user);
            userRepository.insert(userInstance);
            log.info("insertUser {} userInstance", userInstance);
            return userInstance;
        } else {
            log.warn("insertUser User " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("User "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    // UPDATE
    public GameUser updateUser(GameUserDto user){
        checkParameterInput(user);

        if(userRepository.findByFirstnameAndUsername(user.firstname() ,user.username())!=null){
            deleteUser(new GameUserDto(userRepository.findByFirstnameAndUsername(user.firstname() ,user.username())));
            GameUser userInstance = createInstanceByDTO(user);
            log.info("updateUser {} userInstance", userInstance);
            return userInstance;
        } else {
            log.warn("updateUser User " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("User "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    // DELETE
    public void deleteUser(GameUserDto user) {
        checkParameterInput(user);
        if(userRepository.findByFirstnameAndUsername(user.firstname() ,user.username())!=null) {
            log.info("deleteUser {} user", user);
            userRepository.delete(userRepository.findByFirstnameAndUsername(user.firstname(), user.username()));
        }
        else {
            log.warn("deleteUser User " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("User "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void checkParameterInput(GameUserDto user){
        if(user.username()==null||user.username().isBlank()) {
            log.warn("checkParameterInput User.Firstname" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Username " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(user.firstname()==null||user.firstname().isBlank()) {
            log.warn("checkParameterInput User.Firstname" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Firstname " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public GameUser createInstanceByDTO(GameUserDto user){
        GameUser userInstance = GameUser.builder()
                .created_at(user.localDateTime())
                .name(user.name())
                .username(user.username())
                .birthDate(user.birthDate())
                .firstname(user.firstname())
                .surnames(user.surnames())
                .token(user.token())
                .build();
        userRepository.insert(userInstance);
        log.info("createInstanceByMutateCommand {} userInstance", userInstance);
        return userInstance;
    }
}
