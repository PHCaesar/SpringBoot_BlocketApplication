package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateUserCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.UserRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    public final UserRepository userRepository;

    // GET
    public GameUser getUserByName(MutateUserCommand user){
        checkParameterInput(user);

        var realUser = userRepository.findByFirstnameAndUsername(user.firstname ,user.username);
        return realUser;
    }

    // CRUD

    // CREATE
    public GameUser insertUser(MutateUserCommand user){
        checkParameterInput(user);
        if(userRepository.findByFirstnameAndUsername(user.firstname ,user.username)==null){
            GameUser userInstance = createInstanceByMutateCommand(user);
            userRepository.insert(userInstance);
            return userInstance;
        } else throw new IllegalArgumentException("User "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
    }

    // UPDATE
    public GameUser updateUser(MutateUserCommand user){
        checkParameterInput(user);

        if(userRepository.findByFirstnameAndUsername(user.firstname ,user.username)!=null){
            GameUser userInstance = createInstanceByMutateCommand(user);
            userRepository.insert(userInstance);
            return userInstance;
        } else throw new IllegalArgumentException("User "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    // DELETE
    public void deleteUser(MutateUserCommand user){
        checkParameterInput(user);
        if(userRepository.findByFirstnameAndUsername(user.firstname ,user.username)!=null)
            userRepository.delete(userRepository.findByFirstnameAndUsername(user.firstname ,user.username));
        else throw new IllegalArgumentException("User "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    public void checkParameterInput(MutateUserCommand user){
        if(user.username.equals(null))
            throw new IllegalArgumentException("Username "+ UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        if(user.firstname.equals(null))
            throw new IllegalArgumentException("Firstname "+UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
    }

    public GameUser createInstanceByMutateCommand(MutateUserCommand user){
        GameUser userInstance = new GameUser();
        userInstance.setName(user.name);
        userInstance.setUsername(user.username);
        userInstance.setFirstname(user.firstname);
        userInstance.setBirthDate(user.birthDate);
        userInstance.setSurnames(user.surnames);
        return userInstance;
    }
}
