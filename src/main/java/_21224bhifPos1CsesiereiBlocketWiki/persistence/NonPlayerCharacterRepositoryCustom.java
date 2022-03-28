package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateNonPlayerCharacterCommand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonPlayerCharacterRepositoryCustom {
    void insert(NonPlayerCharacter nonPlayerCharacter);

    NonPlayerCharacter findByName(String name);
    List<NonPlayerCharacter> findByShopItemsNotNull();
    List<NonPlayerCharacter> findByHealth(float health);
    public NonPlayerCharacter findByMutateCommand(MutateNonPlayerCharacterCommand mutateNonPlayerCharacterCommand);
}
