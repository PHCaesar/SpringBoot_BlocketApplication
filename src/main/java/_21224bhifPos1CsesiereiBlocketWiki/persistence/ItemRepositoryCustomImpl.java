package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
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
    public void insert(Item item) {
        entityManager.persist(item);
        entityManager.flush();
    }

    @Override
    public Item findByItemID(int id){
        return entityManager.find(Item.class, id);
    }

    @Override
    public Item findByName(String name) {
        String sqlQueryString = "SELECT id FROM Item WHERE name = :name";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("name", name);
        Long id = query.getSingleResult();

        return entityManager.find(Item.class, id);
    }

    @Override
    public List<Item> findBySizeAfter(int size) {
        return findBySizeParameterized(size,false);
    }

    @Override
    public List<Item> findBySizeBefore(int size) {
        return findBySizeParameterized(size,false);
    }

    public List<Item> findBySizeParameterized(int size ,boolean range){
        String sqlQueryString;
        if(range){
            sqlQueryString = "SELECT id FROM Item WHERE size > :size";
        }else
            sqlQueryString = "SELECT id FROM Item WHERE size < :size";

        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("size", size);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(Item.class,x)).collect(Collectors.toList());
    }
}
