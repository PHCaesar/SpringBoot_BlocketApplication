package _21224bhifPos1CsesiereiBlocketWiki.Services;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateMobCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateNonPlayerCharacterCommand;
import _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions.UniversalExceptionStatements;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.NonPlayerCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class NonPlayerCharacterService {

    public final NonPlayerCharacterRepository nonPlayerCharacterRepository;

    // GET
    public NonPlayerCharacter getMobByName(MutateNonPlayerCharacterCommand npc){
        checkParameterInput(npc);

        var realNPC = nonPlayerCharacterRepository.findByName(npc.name);
        return realNPC;
    }

    // CRUD

    // CREATE
    public NonPlayerCharacter insertNPC(MutateNonPlayerCharacterCommand npc){
        checkParameterInput(npc);
        if(nonPlayerCharacterRepository.findByName(npc.name)==null){
            NonPlayerCharacter npcInstance = createInstanceByMutateCommand(npc);
            nonPlayerCharacterRepository.insert(npcInstance);
            return npcInstance;
        } else throw new IllegalArgumentException("NPC "+ UniversalExceptionStatements.DUPLICATE_DATA_FOUND);
    }

    // UPDATE
    public NonPlayerCharacter updateNPC(MutateNonPlayerCharacterCommand npc){
        checkParameterInput(npc);

        if(nonPlayerCharacterRepository.findByName(npc.name)!=null){
            NonPlayerCharacter npcInstance = createInstanceByMutateCommand(npc);
            nonPlayerCharacterRepository.insert(npcInstance);
            return npcInstance;
        } else throw new IllegalArgumentException("NPC "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    // DELETE
    public void deleteBlock(MutateNonPlayerCharacterCommand npc){
        checkParameterInput(npc);
        if(nonPlayerCharacterRepository.findByName(npc.name)!=null)
            nonPlayerCharacterRepository.delete(nonPlayerCharacterRepository.findByName(npc.name));
        else throw new IllegalArgumentException("NPC "+UniversalExceptionStatements.DATA_NOT_FOUND);
    }

    public void checkParameterInput(MutateNonPlayerCharacterCommand npc){
        if(npc.name.isEmpty())
            throw new IllegalArgumentException("Name "+ UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
        if(npc.health == 0)
            throw new IllegalArgumentException("Health "+UniversalExceptionStatements.BLANK_OR_EMPTY_MSG);
    }

    public NonPlayerCharacter createInstanceByMutateCommand(MutateNonPlayerCharacterCommand npc){
        NonPlayerCharacter npcInstance = new NonPlayerCharacter();
        npcInstance.setName(npc.name);
        npcInstance.setHealth(npc.health);
        npcInstance.setShopItems(npc.shopItems);
        return npcInstance;
    }
}
