package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameContent;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
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
        String sqlQueryString = "SELECT id FROM GameUser WHERE user = :user";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("user", user);
        Long id = query.getSingleResult();

        return entityManager.find(GameContent.class, id);
    }
}
