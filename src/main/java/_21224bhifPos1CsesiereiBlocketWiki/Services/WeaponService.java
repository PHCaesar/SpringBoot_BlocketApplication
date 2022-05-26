package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.WeaponDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateWeaponCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.IWeaponService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class WeaponService implements IWeaponService {

    public final WeaponRepository weaponRepository;
    //GET
    public Weapon getByName(String name) {
        var realWep = weaponRepository.findByName(name);
        log.info("Found {} realWep", realWep);

        return realWep;
    }

    //CRUD

    //CREATE
    public Weapon insertWeapon(WeaponDto wep){
        checkParameterInput(wep);
        try{
            weaponRepository.findByName(wep.name());
            log.warn("insertWeapon Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }catch(EmptyResultDataAccessException exception){

            Weapon wepInstance = createInstanceByDto(wep);
            weaponRepository.insert(wepInstance);
            log.info("insertWeapon {} wepInstance", wepInstance);
            return wepInstance;
        }
    }

    //Update
    public Weapon updateWeapon(WeaponDto wep){
        checkParameterInput(wep);
        try {
            weaponRepository.findByName(wep.name());
            weaponRepository.delete(weaponRepository.findByName(wep.name()));
            Weapon wepInstance = createInstanceByDto(wep);
            log.info("updateWeapon {} wepInstance", wepInstance);
            return wepInstance;
        }
        catch(EmptyResultDataAccessException exception){
            log.warn("updateWeapon Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Weapon " + UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    //DELETE
    public void deleteWeapon(WeaponDto wep){
        checkParameterInput(wep);
        try{
            weaponRepository.findByName(wep.name());
            log.info("deleteWeapon {} wep", wep);
            weaponRepository.delete(weaponRepository.findByName((wep.name())));
        }
        catch (EmptyResultDataAccessException exception){
            log.warn("deleteWeapon Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Weapon "+ UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    public void deleteAll() {
        weaponRepository.deleteAll();
    }


    public void checkParameterInput(WeaponDto wep){
        Objects.requireNonNull(wep);
        if(wep.damage() == 0) {
            log.warn("checkParameterInput Weapon.Damage" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Damage " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(wep.classification()==null) {
            log.warn("checkParameterInput Weapon.Classification" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Classification " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(wep.description()==null||wep.description().isEmpty()) {
            log.warn("checkParameterInput Weapon.Description" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Description " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(wep.name()==null||wep.name().isEmpty()) {
            log.warn("checkParameterInput Weapon.Name" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public Weapon createInstanceByDto(WeaponDto wep){
        Weapon wepInstance = Weapon.builder()
                .created_at(wep.created_at())
                .token(wep.token())
                .classification(wep.classification())
                .description(wep.description())
                .damage(wep.damage())
                .name(wep.name()).build();
        weaponRepository.insert(wepInstance);
        log.info("createInstanceByMutateCommand {} wepInstance", wepInstance);
        return wepInstance;
    }
}
