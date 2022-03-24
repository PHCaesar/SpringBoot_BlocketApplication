package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
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
public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(UsableItem item) {
        entityManager.persist(item);
        entityManager.flush();
    }

    @Override
    public UsableItem findByItemID(int id){
        return entityManager.find(UsableItem.class, id);
    }

    @Override
    public UsableItem findByName(String name) {
        String sqlQueryString = "SELECT id FROM Item WHERE name = :name";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("name", name);
        Long id = query.getSingleResult();

        return entityManager.find(UsableItem.class, id);
    }

    @Override
    public List<UsableItem> findBySizeAfter(int size) {
        return findBySizeParameterized(size,false);
    }

    @Override
    public List<UsableItem> findBySizeBefore(int size) {
        return findBySizeParameterized(size,false);
    }

    public List<UsableItem> findBySizeParameterized(int size ,boolean range){
        String sqlQueryString;
        if(range){
            sqlQueryString = "SELECT id FROM Item WHERE size > :size";
        }else
            sqlQueryString = "SELECT id FROM Item WHERE size < :size";

        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("size", size);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(UsableItem.class,x)).collect(Collectors.toList());
    }
}
