package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateWeaponCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.WeaponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class WeaponService {
    //TODO : Use DTOs

    public final WeaponRepository weaponRepository;
    //GET
    public Weapon getByName(MutateWeaponCommand wep) {
        checkParameterInput(wep);

        var realWep = weaponRepository.findByName(wep.getDescription());
        log.info("Found {} realWep", realWep);

        return realWep;
    }

    //CRUD

    //CREATE
    public Weapon insertWeapon(MutateWeaponCommand wep){
        checkParameterInput(wep);
        if(weaponRepository.findByName(wep.getDescription())==null){
            Weapon wepInstance = createInstanceByMutateCommand(wep);
            weaponRepository.insert(wepInstance);
            log.info("insertWeapon {} wepInstance", wepInstance);
            return wepInstance;
        }else {
            log.warn("insertWeapon Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    //Update
    public Weapon updateWeapon(MutateWeaponCommand wep){
        checkParameterInput(wep);
        if (weaponRepository.findByName(wep.getDescription()) != null) {
            Weapon wepInstance = createInstanceByMutateCommand(wep);
            weaponRepository.insert(wepInstance);
            log.info("updateWeapon {} wepInstance", wepInstance);
            return wepInstance;
        }else {
            log.warn("updateWeapon Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Weapon " + UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    //DELETE
    public void deleteWeapon(MutateWeaponCommand wep){
        checkParameterInput(wep);
        if(weaponRepository.findByName(wep.getDescription())!=null) {
            log.info("deleteWeapon {} wep", wep);
            weaponRepository.delete(weaponRepository.findByName((wep.getDescription())));
        }
        else {
            log.warn("deleteWeapon Weapon " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("Weapon "+ UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }


    public void checkParameterInput(MutateWeaponCommand wep){
        if(wep.getDamage() == 0) {
            log.warn("checkParameterInput Weapon.Damage" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Damage " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(wep.getClassification().equals(null)) {
            log.warn("checkParameterInput Weapon.Classification" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Classification " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(wep.getDescription().equals(null)) {
            log.warn("checkParameterInput Weapon.Description" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Description " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public Weapon createInstanceByMutateCommand(MutateWeaponCommand wep){
        Weapon wepInstance = new Weapon();
        wepInstance.setClassification(wep.getClassification());
        wepInstance.setDamage(wep.getDamage());
        wepInstance.setDescription(wep.getDescription());
        weaponRepository.insert(wepInstance);
        log.info("createInstanceByMutateCommand {} wepInstance", wepInstance);
        return wepInstance;
    }
}
