package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.NonPlayerCharacterDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces.INonPlayerCharacterService;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.NonPlayerCharacterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Log4j2
@RequiredArgsConstructor
@Service
@Transactional
public class NonPlayerCharacterService implements INonPlayerCharacterService {

    public final NonPlayerCharacterRepository nonPlayerCharacterRepository;

    // GET
    public NonPlayerCharacter getNonPlayerCharacterByName(String name){
        var realNPC = nonPlayerCharacterRepository.findByName(name);
        log.info("Found {} realNPC", realNPC);
        return realNPC;
    }

    // CRUD

    // CREATE
    public NonPlayerCharacter insertNPC(NonPlayerCharacterDto npc){
        checkParameterInput(npc);
        if(nonPlayerCharacterRepository.findByName(npc.name())==null){
            NonPlayerCharacter npcInstance = createInstanceByDTO(npc);
            nonPlayerCharacterRepository.insert(npcInstance);
            log.info("insertNPC {} npcInstance", npcInstance);
            return npcInstance;
        } else {
            log.warn("insertNPC NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    // UPDATE
    public NonPlayerCharacter updateNPC(NonPlayerCharacterDto npc){
        checkParameterInput(npc);

        if(nonPlayerCharacterRepository.findByName(npc.name())!=null){
            NonPlayerCharacter npcInstance = createInstanceByDTO(npc);
            nonPlayerCharacterRepository.insert(npcInstance);
            log.info("updateNPC {} npcInstance", npcInstance);
            return npcInstance;
        } else {
            log.warn("updateNPC NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("NPC " + UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    // DELETE
    public void deleteNonPlayerCharacter(NonPlayerCharacterDto npc) {
        checkParameterInput(npc);
        if(nonPlayerCharacterRepository.findByName(npc.name())!=null) {
            log.info("deleteNonPlayerCharacter {} npc", npc);
            nonPlayerCharacterRepository.delete(nonPlayerCharacterRepository.findByName(npc.name()));
        }
        else {
            log.warn("deleteNonPlayerCharacter NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("NPC "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    @Override
    public void deleteAll() {
        nonPlayerCharacterRepository.deleteAll();
    }

    public void checkParameterInput(NonPlayerCharacterDto npc){
        if(npc.name().isEmpty()) {
            log.warn("checkParameterInput NPC.Name" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(npc.health() == 0) {
            log.warn("checkParameterInput NPC.Health" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Health " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public NonPlayerCharacter createInstanceByDTO(NonPlayerCharacterDto npc){
        NonPlayerCharacter npcInstance = NonPlayerCharacter.builder()
                .name(npc.name())
                .health(npc.health())
                .token(npc.token())
                .shopItems(npc.shopitems()).build();
        nonPlayerCharacterRepository.insert(npcInstance);
        log.info("createInstanceByMutateCommand {} npcInstance", npcInstance);
        return npcInstance;
    }
}
