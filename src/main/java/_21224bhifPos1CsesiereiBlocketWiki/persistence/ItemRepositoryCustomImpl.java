package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.UsableItemDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.SQLQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    public UsableItem findByItemID(long id){
        return entityManager.find(UsableItem.class, id);
    }

    @Override
    public UsableItem findByName(String name) {
        Query sqlQuery = entityManager.createQuery("SELECT id FROM UsableItem WHERE name = :name");
        sqlQuery.setParameter("name", name);
        var id =sqlQuery.getSingleResult();

        return entityManager.find(UsableItem.class, id);
    }

    @Override
    public List<UsableItem> findBySizeAfter(int size) { return findBySizeParameterized(size,true);}

    @Override
    public List<UsableItem> findBySizeBefore(int size) {
        return findBySizeParameterized(size,false);
    }

    @Override
    public UsableItem updateItem(UsableItem item){
        entityManager.remove(item);
        entityManager.persist(item);
        entityManager.flush();
        return findByName(item.getName());
    }

    public List<UsableItem> findBySizeParameterized(int size ,boolean range){
        Query sqlQueryString;
        if(range){
            sqlQueryString = entityManager.createQuery("SELECT id FROM UsableItem WHERE size > :size");
        }else
            sqlQueryString = entityManager.createQuery("SELECT id FROM UsableItem WHERE size < :size");

        sqlQueryString.setParameter("size", size);

        List<Long> ids = sqlQueryString.getResultList();
        return ids.stream().map(x-> entityManager.find(UsableItem.class,x)).collect(Collectors.toList());
    }
}
