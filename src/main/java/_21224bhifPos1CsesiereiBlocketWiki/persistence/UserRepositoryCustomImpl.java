package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.User;
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
    public void insert(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public List<User> findByBirthDateAfter(LocalDate birthDate) {
        String sqlQueryString = "SELECT id FROM User WHERE birthDate < :birthDate";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("birthDate", birthDate);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(User.class,x)).collect(Collectors.toList());
    }

    @Override
    public List<User> findByBirthDateBefore(LocalDate birthDate) {
        String sqlQueryString = "SELECT id FROM User WHERE birthDate > :birthDate";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("birthDate", birthDate);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(User.class,x)).collect(Collectors.toList());
    }

    @Override
    public User findByFirstnameAndUsername(String firstname, String username) {
        String sqlQueryString = "SELECT id FROM User WHERE firstname = :firstname AND username = :username";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("firstname", firstname).setParameter("username", username);
        Long id = query.getSingleResult();

        return entityManager.find(User.class, id);
    }

    @Override
    public User findByFirstnameAndSurnames(String firstname, List<Surname> surnames) {
        String sqlQueryString = "SELECT id FROM User WHERE firstname = :firstname AND surnames = :surnames";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("firstname", firstname).setParameter("surnames", surnames);
        Long id = query.getSingleResult();

        return entityManager.find(User.class, id);
    }
}
