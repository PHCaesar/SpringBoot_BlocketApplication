package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameContent;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import org.springframework.stereotype.Repository;

@Repository
public interface GameContentRepositoryCustom {
    void insert(GameContent gameContent);

    GameContent findByUser(GameUser user);
}
