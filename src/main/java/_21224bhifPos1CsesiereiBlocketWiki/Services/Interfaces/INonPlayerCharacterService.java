package _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.NonPlayerCharacterDto;

public interface INonPlayerCharacterService {
    public NonPlayerCharacter getNonPlayerCharacterByName(String name);
    public NonPlayerCharacter insertNPC(NonPlayerCharacterDto npc);
    public NonPlayerCharacter updateNPC(NonPlayerCharacterDto npc);
    public void deleteNonPlayerCharacter(NonPlayerCharacterDto npc);
    public void deleteAll();
}
