package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameContent;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Getter
@RequiredArgsConstructor
@Component
public class GameContentRepositoryCustomImpl implements GameContentRepositoryCustom {

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(GameContent gameContent) {
        entityManager.persist(gameContent);
        entityManager.flush();
    }

    @Override
    public GameContent findByUser(GameUser user) {

        Query query = entityManager.createQuery("SELECT id FROM GameContent WHERE loggedInGameUser = :user");
        query.setParameter("user", user);

        return entityManager.find(GameContent.class, query.getSingleResult());
    }
}
