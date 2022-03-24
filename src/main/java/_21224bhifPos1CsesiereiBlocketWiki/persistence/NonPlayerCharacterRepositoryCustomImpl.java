package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor

@Component
public class NonPlayerCharacterRepositoryCustomImpl implements  NonPlayerCharacterRepositoryCustom{

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(NonPlayerCharacter nonPlayerCharacter) {
        entityManager.persist(nonPlayerCharacter);
        entityManager.flush();
    }

    public NonPlayerCharacter findByName(String name) {
        String sqlQueryString = "SELECT id FROM NonPlayerCharacter WHERE name = :name";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("name", name);

        Long id = query.getSingleResult();
        return entityManager.find(NonPlayerCharacter.class, id);
    }

    @Override
    public List<NonPlayerCharacter> findByShopItemsNotNull() {
        String sqlQueryString = "SELECT id FROM NonPlayerCharacter WHERE shopItems is not NULL";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(NonPlayerCharacter.class,x)).collect(Collectors.toList());
    }

    @Override
    public List<NonPlayerCharacter> findByHealth(float health) {
        String sqlQueryString = "SELECT id FROM NonPlayerCharacter WHERE health = :health";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("health", health);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(NonPlayerCharacter.class,x)).collect(Collectors.toList());
    }
}
