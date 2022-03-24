package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonPlayerCharacterRepositoryCustom {
    void insert(NonPlayerCharacter nonPlayerCharacter);

    NonPlayerCharacter findByName(String name);
    List<NonPlayerCharacter> findByShopItemsNotNull();
    List<NonPlayerCharacter> findByHealth(float health);
}
