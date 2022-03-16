package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
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
public class WeaponRepositoryCustomImpl implements WeaponRepositoryCustom{

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Weapon weapon) {
        entityManager.persist(weapon);
        entityManager.flush();
    }

    @Override
    public Weapon findByName(String name) {
        String sqlQueryString = "SELECT id FROM Weapon WHERE name = :name";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("name", name);
        Long id = query.getSingleResult();

        return entityManager.find(Weapon.class, id);
    }

    @Override
    public List<Weapon> findByClassification(WeaponClass classification) {
        String sqlQueryString = "SELECT id FROM Weapon WHERE classification = :classification";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("classification", classification);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(Weapon.class,x)).collect(Collectors.toList());
    }

    @Override
    public List<Weapon> findByDamageLower(int damage) {
        String sqlQueryString = "SELECT id FROM Weapon WHERE damage < :damage";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("damage", damage);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(Weapon.class,x)).collect(Collectors.toList());
    }

    @Override
    public List<Weapon> findByDamageHigher(int damage) {
        String sqlQueryString = "SELECT id FROM Weapon WHERE damage > :damage";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("damage", damage);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(Weapon.class,x)).collect(Collectors.toList());
    }
}
