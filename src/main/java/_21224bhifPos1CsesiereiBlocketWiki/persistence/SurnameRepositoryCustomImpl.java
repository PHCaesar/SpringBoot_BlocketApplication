package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Getter
@RequiredArgsConstructor

@Component
public class SurnameRepositoryCustomImpl implements SurnameRepositoryCustom {

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Surname surname) {
        entityManager.persist(surname);
        entityManager.flush();
    }

    @Override
    public Surname findByName(String name) {
        String sqlQueryString = "SELECT id FROM Surname WHERE name = :name";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("name", name);
        Long id = query.getSingleResult();

        return entityManager.find(Surname.class, id);
    }
}
