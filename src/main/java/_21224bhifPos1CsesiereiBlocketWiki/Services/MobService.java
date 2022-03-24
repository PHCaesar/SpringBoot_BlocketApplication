package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateBlockCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.BlockRepository;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.MobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class MobService {

    public final MobRepository mobRepository;

    // GET
    public Mob getMobByName(MutateMobCommand mob){
        checkParameterInput(mob);

        var realMob = mobRepository.findByName(mob.name);
        return realMob;
    }

    // CRUD

    // CREATE
    public Mob insertBlock(MutateMobCommand mob){
        checkParameterInput(mob);
        if(mobRepository.findByName(mob.name)==null){
            Mob blockInstance = createInstanceByMutateCommand(mob);
            mobRepository.insert(blockInstance);
            return blockInstance;
        } else throw new IllegalArgumentException("Mob "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
    }

    // UPDATE
    public Mob updateBlock(MutateMobCommand mob){
        checkParameterInput(mob);

        if(mobRepository.findByName(mob.name)!=null){
            Mob blockInstance = createInstanceByMutateCommand(mob);
            mobRepository.insert(blockInstance);
            return blockInstance;
        } else throw new IllegalArgumentException("Mob "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    // DELETE
    public void deleteBlock(MutateMobCommand mob){
        checkParameterInput(mob);
        if(mobRepository.findByName(mob.name)!=null)
            mobRepository.delete(mobRepository.findByName(mob.name));
        else throw new IllegalArgumentException("Mob "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    public void checkParameterInput(MutateMobCommand mob){
        if(mob.name.isEmpty())
            throw new IllegalArgumentException("Name "+ UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        if(mob.type.equals(null))
            throw new IllegalArgumentException("Type "+UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
    }

    public Mob createInstanceByMutateCommand(MutateMobCommand mob){
        Mob mobInstance = new Mob();
        mobInstance.setName(mob.name);
        mobInstance.setType(mob.type);
        mobInstance.setDrops(mob.drops);
        return mobInstance;
    }
}
