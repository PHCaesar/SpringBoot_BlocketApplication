package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.MobDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateMobCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobRepository extends JpaRepository<Mob,Long>,
        QuerydslPredicateExecutor<Mob>,
        MobRepositoryCustom
{

    Mob findByName(String name);
    List<Mob> findByDrops(List<UsableItem> drops);
    List<Mob> findByType(MobType type);
    Mob findByDTO(MobDto mutateMobCommand);
}
