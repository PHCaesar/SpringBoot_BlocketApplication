package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobRepositoryCustom {
    void insert(Mob mob);

    Mob findByName(String name);
    List<Mob> findByDrops(List<UsableItem> drops);
    List<Mob> findByType(MobType type);
    Mob findByDTO(MobDto mutateMobCommand);
}
