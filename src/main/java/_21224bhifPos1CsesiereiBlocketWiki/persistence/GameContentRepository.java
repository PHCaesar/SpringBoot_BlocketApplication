package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameContent;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GameContentRepository extends JpaRepository<GameContent,Long>,
        QuerydslPredicateExecutor<GameContent>,
        GameContentRepositoryCustom {

    GameContent findByUser(GameUser user);
}
