package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateSurnameCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.SurnameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;

import javax.transaction.Transactional;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class SurnameService {
    //TODO : Use DTOs

    public final SurnameRepository surnameRepository;

    //GET
    public Surname getByName(MutateSurnameCommand srn) {
        checkParameterInput(srn);

        var SurNm = surnameRepository.findByName(srn.getName());
        log.info("Found {} SurNm", SurNm);
        return SurNm;
    }

    //CRUD

    //CREATE
    public Surname insertSurname(MutateSurnameCommand srn){
        checkParameterInput(srn);
        if(surnameRepository.findByName(srn.getName())== null){
            Surname srnInstance = createInstanceByMutateCommand(srn);
            surnameRepository.insert(srnInstance);
            log.info("insertSurname {} srnInstance", srnInstance);
            return srnInstance;
        } else {
            log.warn("insertSurname SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    //Update
    public Surname updateSurname(MutateSurnameCommand srn){
        checkParameterInput(srn);
        if (surnameRepository.findByName(srn.getName()) != null) {
            Surname srnInstance = createInstanceByMutateCommand(srn);
            surnameRepository.insert(srnInstance);
            log.info("updateSurname {} srnInstance", srnInstance);
            return srnInstance;
        }else {
            log.warn("updateSurname SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("SRN " + UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    //DELETE
    public void deleteSurname(MutateSurnameCommand srn){
        checkParameterInput(srn);
        if(surnameRepository.findByName(srn.getName())!=null) {
            log.info("deleteSurname {} srn", srn);
            surnameRepository.delete(surnameRepository.findByName((srn.getName())));
        }
        else {
            log.warn("deleteSurname SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("SRN "+ UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }


    public void checkParameterInput(MutateSurnameCommand srn) {
        if (srn.getName().isEmpty()){
            log.warn("checkParameterInput SRN.Name" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public Surname createInstanceByMutateCommand(MutateSurnameCommand srn){
        Surname srnInstance = new Surname();
        srnInstance.setName(srn.getName());
        surnameRepository.insert(srnInstance);
        log.info("createInstanceByMutateCommand {} srnInstance", srnInstance);
        return srnInstance;
    }
}
