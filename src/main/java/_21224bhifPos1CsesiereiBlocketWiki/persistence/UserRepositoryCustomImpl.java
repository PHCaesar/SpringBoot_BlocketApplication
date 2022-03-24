package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor

@Component
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(GameUser gameUser) {
        entityManager.persist(gameUser);
        entityManager.flush();
    }

    @Override
    public List<GameUser> findByBirthDateAfter(LocalDate birthDate) {
        String sqlQueryString = "SELECT id FROM User WHERE birthDate < :birthDate";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("birthDate", birthDate);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(GameUser.class,x)).collect(Collectors.toList());
    }

    @Override
    public List<GameUser> findByBirthDateBefore(LocalDate birthDate) {
        String sqlQueryString = "SELECT id FROM User WHERE birthDate > :birthDate";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("birthDate", birthDate);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(GameUser.class,x)).collect(Collectors.toList());
    }

    @Override
    public GameUser findByFirstnameAndUsername(String firstname, String username) {
        String sqlQueryString = "SELECT id FROM User WHERE firstname = :firstname AND username = :username";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("firstname", firstname).setParameter("username", username);
        Long id = query.getSingleResult();

        return entityManager.find(GameUser.class, id);
    }

    @Override
    public GameUser findByFirstnameAndSurnames(String firstname, List<Surname> surnames) {
        String sqlQueryString = "SELECT id FROM User WHERE firstname = :firstname AND surnames = :surnames";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("firstname", firstname).setParameter("surnames", surnames);
        Long id = query.getSingleResult();

        return entityManager.find(GameUser.class, id);
    }
}
