package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateNonPlayerCharacterCommand;
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
public class NonPlayerCharacterService {
    //TODO : Use DTOs

    public final NonPlayerCharacterRepository nonPlayerCharacterRepository;

    // GET
    public NonPlayerCharacter getNonPlayerCharacterByName(MutateNonPlayerCharacterCommand npc){
        checkParameterInput(npc);
        var realNPC = nonPlayerCharacterRepository.findByName(npc.getName());
        log.info("Found {} realNPC", realNPC);
        return realNPC;
    }

    // CRUD

    // CREATE
    public NonPlayerCharacter insertNPC(MutateNonPlayerCharacterCommand npc){
        checkParameterInput(npc);
        if(nonPlayerCharacterRepository.findByName(npc.getName())==null){
            NonPlayerCharacter npcInstance = createInstanceByMutateCommand(npc);
            nonPlayerCharacterRepository.insert(npcInstance);
            log.info("insertNPC {} npcInstance", npcInstance);
            return npcInstance;
        } else {
            log.warn("insertNPC NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
        }
    }

    // UPDATE
    public NonPlayerCharacter updateNPC(MutateNonPlayerCharacterCommand npc){
        checkParameterInput(npc);

        if(nonPlayerCharacterRepository.findByName(npc.getName())!=null){
            NonPlayerCharacter npcInstance = createInstanceByMutateCommand(npc);
            nonPlayerCharacterRepository.insert(npcInstance);
            log.info("updateNPC {} npcInstance", npcInstance);
            return npcInstance;
        } else {
            log.warn("updateNPC NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("NPC " + UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    // DELETE
    public void deleteNonPlayerCharacter(MutateNonPlayerCharacterCommand npc) {
        checkParameterInput(npc);
        if(nonPlayerCharacterRepository.findByName(npc.getName())!=null) {
            log.info("deleteNonPlayerCharacter {} npc", npc);
            nonPlayerCharacterRepository.delete(nonPlayerCharacterRepository.findByName(npc.getName()));
        }
        else {
            log.warn("deleteNonPlayerCharacter NPC " + UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
            throw new IllegalArgumentException("NPC "+UniversalExceptionStatements.DATA_NOT_FOUND);
        }
    }

    public void checkParameterInput(MutateNonPlayerCharacterCommand npc){
        if(npc.getName().isEmpty()) {
            log.warn("checkParameterInput NPC.Name" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Name " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
        if(npc.getHealth() == 0) {
            log.warn("checkParameterInput NPC.Health" + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
            throw new IllegalArgumentException("Health " + UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        }
    }

    public NonPlayerCharacter createInstanceByMutateCommand(MutateNonPlayerCharacterCommand npc){
        NonPlayerCharacter npcInstance = NonPlayerCharacter.builder()
                .name(npc.getName())
                .health(npc.getHealth())
                .token(npc.getToken())
                .shopItems(npc.getShopItems()).build();
        nonPlayerCharacterRepository.insert(npcInstance);
        log.info("createInstanceByMutateCommand {} npcInstance", npcInstance);
        return npcInstance;
    }
}
