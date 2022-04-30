package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.SurnameDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.ISurnameService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.SurnameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class SurnameService implements ISurnameService {

    public final SurnameRepository surnameRepository;

    //GET
    public Surname getByName(String name) {
        var SurNm = surnameRepository.findByName(name);
        log.info("Found {} SurNm", SurNm);
        return SurNm;
    }

    //CRUD

    //CREATE
    public Surname insertSurname(SurnameDto srn){
        checkParameterInput(srn);
        if(surnameRepository.findByName(srn.name())== null){
            Surname srnInstance = createInstanceByDTO(srn);
            surnameRepository.insert(srnInstance);
            log.info("insertSurname {} srnInstance", srnInstance);
            return srnInstance;
        } else {
            log.warn("insertSurname SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    //Update
    public Surname updateSurname(SurnameDto srn){
        checkParameterInput(srn);
        if (surnameRepository.findByName(srn.name()) != null) {
            Surname srnInstance = createInstanceByDTO(srn);
            surnameRepository.insert(srnInstance);
            log.info("updateSurname {} srnInstance", srnInstance);
            return srnInstance;
        }else {
            log.warn("updateSurname SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("SRN " + UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    //DELETE
    public void deleteSurname(SurnameDto srn){
        checkParameterInput(srn);
        if(surnameRepository.findByName(srn.name())!=null) {
            log.info("deleteSurname {} srn", srn);
            surnameRepository.delete(surnameRepository.findByName((srn.name())));
        }
        else {
            log.warn("deleteSurname SRN " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("SRN "+ UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    public void deleteAll() {
        surnameRepository.deleteAll();
    }


    public void checkParameterInput(SurnameDto srn) {
        if (srn.name().isEmpty()){
            log.warn("checkParameterInput SRN.Name" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public Surname createInstanceByDTO(SurnameDto srn){
        Surname srnInstance = new Surname();
        srnInstance.setName(srn.name());
        surnameRepository.insert(srnInstance);
        log.info("createInstanceByMutateCommand {} srnInstance", srnInstance);
        return srnInstance;
    }
}
