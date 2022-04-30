package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.IMobService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.MobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class MobService implements IMobService {

    public final MobRepository mobRepository;

    // GET
    public Mob getMobByName(String mobname){
        var realMob = mobRepository.findByName(mobname);
        log.info("Found {} realMob", realMob);
        return realMob;
    }

    public List<Mob> getAllMobs(){
        return mobRepository.findAll();
    }
    // CRUD

    // CREATE
    public Mob insertMob(MobDto mob){
        checkParameterInput(mob);
        if(mobRepository.findByDTO(mob)==null){
            Mob mobInstance = createInstanceByDTO(mob);
            mobRepository.insert(mobInstance);
            log.info("insertMob {} mobInstance", mobInstance);
            return mobInstance;
        } else {
            log.warn("insertMob Mob " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Mob "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    // UPDATE
    public Mob updateMob(MobDto mob){
        checkParameterInput(mob);
        if(mobRepository.findByDTO(mob)!=null){
            Mob mobInstance = createInstanceByDTO(mob);
            mobRepository.insert(mobInstance);
            log.info("updateMob {} mobInstance", mobInstance);
            return mobInstance;
        } else {
            log.warn("updateMob Mob " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Mob "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    // DELETE
    public void deleteMob(MobDto mob){
        checkParameterInput(mob);
        if(mobRepository.findByDTO(mob)!=null) {
            log.info("deleteMob {} mob", mob);
            mobRepository.delete(mobRepository.findByDTO(mob));
        }
        else {
            log.warn("deleteMob Mob " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Mob "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    public void deleteAll() {
        mobRepository.deleteAll();
    }

    public void checkParameterInput(MobDto mob){
        if(mob.name().isEmpty()) {
            log.warn("checkParameterInput Mob.Name" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(mob.type().equals(null)) {
            log.warn("checkParameterInput Mob.Type" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Type " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public Mob createInstanceByDTO(MobDto mob){
        Mob mobInstance = new Mob();
        mobInstance.setName(mob.name());
        mobInstance.setType(mob.type());
        mobInstance.setToken(mob.token());
        //mobInstance.setDrops(mob.getDrops());
        mobRepository.insert(mobInstance);
        log.info("createInstanceByMutateCommand {} mobInstance", mobInstance);
        return mobInstance;
    }
}
