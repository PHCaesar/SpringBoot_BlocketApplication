package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        Query queryString = entityManager.createQuery("SELECT id FROM GameUser WHERE birthDate < :birthDate");
        queryString.setParameter("birthDate", birthDate);

        List<Long> ids = queryString.getResultList();
        return ids.stream().map(x-> entityManager.find(GameUser.class,x)).collect(Collectors.toList());
    }

    @Override
    public List<GameUser> findByBirthDateBefore(LocalDate birthDate) {
        Query sqlQueryString = entityManager.createQuery("SELECT id FROM GameUser WHERE birthDate > :birthDate");
        sqlQueryString.setParameter("birthDate", birthDate);

        List<Long> ids = sqlQueryString.getResultList();
        return ids.stream().map(x-> entityManager.find(GameUser.class,x)).collect(Collectors.toList());
    }

    @Override
    public GameUser findByFirstnameAndUsername(String firstname, String username) {
        Query query = entityManager.createQuery("SELECT id FROM GameUser WHERE firstname = :firstname AND username = :username");
        query.setParameter("firstname", firstname).setParameter("username", username);
        try{
            return entityManager.find(GameUser.class,  query.getSingleResult());
        } catch (Exception e) {return null;}
    }

    @Override
    public GameUser findByFirstnameAndSurnames(String firstname, List<Surname> surnames) {
        Query sqlQueryString = entityManager.createQuery("SELECT id FROM GameUser WHERE firstname = :firstname AND surnames = :surnames");
        sqlQueryString.setParameter("firstname", firstname).setParameter("surnames", surnames);
        Long id = (Long) sqlQueryString.getSingleResult();

        return entityManager.find(GameUser.class, id);
    }
}
