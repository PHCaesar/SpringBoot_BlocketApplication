package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateUserCommand;
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
public class UserService {
    //TODO : Use DTOs

    public final UserRepository userRepository;

    // GET
    public GameUser getUserByName(MutateUserCommand user){
        checkParameterInput(user);

        var realUser = userRepository.findByFirstnameAndUsername(user.getFirstname() ,user.getUsername());
        log.info("Found {} realUser", realUser);
        return realUser;
    }

    public List<GameUser> getAllUser()
    {
        return userRepository.findAll();
    }

    // CREATE
    public GameUser insertUser(MutateUserCommand user){
        checkParameterInput(user);
        if(userRepository.findByFirstnameAndUsername(user.getFirstname() ,user.getUsername())==null){
            GameUser userInstance = createInstanceByMutateCommand(user);
            userRepository.insert(userInstance);
            log.info("insertUser {} userInstance", userInstance);
            return userInstance;
        } else {
            log.warn("insertUser User " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("User "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    // UPDATE
    public GameUser updateUser(MutateUserCommand user){
        checkParameterInput(user);

        if(userRepository.findByFirstnameAndUsername(user.getFirstname() ,user.getUsername())!=null){
            GameUser userInstance = createInstanceByMutateCommand(user);
            userRepository.insert(userInstance);
            log.info("updateUser {} userInstance", userInstance);
            return userInstance;
        } else {
            log.warn("updateUser User " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("User "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    // DELETE
    public void deleteUser(MutateUserCommand user) {
        checkParameterInput(user);
        if(userRepository.findByFirstnameAndUsername(user.getFirstname() ,user.getUsername())!=null) {
            log.info("deleteUser {} user", user);
            userRepository.delete(userRepository.findByFirstnameAndUsername(user.getFirstname(), user.getUsername()));
        }
        else {
            log.warn("deleteUser User " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("User "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    public void checkParameterInput(MutateUserCommand user){
        if(user.getUsername().equals(null)) {
            log.warn("checkParameterInput User.Firstname" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Username " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(user.getFirstname().equals(null)) {
            log.warn("checkParameterInput User.Firstname" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Firstname " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public GameUser createInstanceByMutateCommand(MutateUserCommand user){
        GameUser userInstance = GameUser.builder()
                .created_at(user.getCreated_at())
                .name(user.getName())
                .username(user.getUsername())
                .birthDate(user.getBirthDate())
                .firstname(user.getFirstname())
                .surnames(user.getSurnames())
                .build();
        userRepository.insert(userInstance);
        log.info("createInstanceByMutateCommand {} userInstance", userInstance);
        return userInstance;
    }
}
