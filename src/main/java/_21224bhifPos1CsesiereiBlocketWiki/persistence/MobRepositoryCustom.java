package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobRepositoryCustom {
    void insert(Mob mob);

    Mob findByName(String name);
    List<Mob> findByDrops(List<Item> drops);
    List<Mob> findByType(MobType type);
}
