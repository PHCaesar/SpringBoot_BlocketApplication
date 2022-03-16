package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonPlayerCharacterRepository extends JpaRepository<NonPlayerCharacter,Long> ,
        QuerydslPredicateExecutor<NonPlayerCharacter> ,
        NonPlayerCharacterRepositoryCustom
{

    List<NonPlayerCharacter> findByShopItemsNotNull();

    //Custom Repo for finding NPC that sells a specific Product (Item)
}
