package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.persistence.BlockRepositoryCustom;
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
public class BlockRepositoryCustomImpl implements BlockRepositoryCustom {

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Block block) {
        entityManager.persist(block);
        entityManager.flush();
    }

    @Override
    public Block findByName(String name) {
        String sqlQueryString = "SELECT id FROM Block WHERE name = :name";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("name", name);
        Long id = query.getSingleResult();

        return entityManager.find(Block.class, id);
    }

    @Override
    public List<Block> findByBlocksDurability(int blockDurability) {
        String sqlQueryString = "SELECT id FROM Block WHERE blockDurability = :blockDurability";
        TypedQuery<Long> query = entityManager.createQuery(sqlQueryString, Long.class);
        query.setParameter("blockDurability", blockDurability);

        List<Long> ids = query.getResultList();
        return ids.stream().map(x-> entityManager.find(Block.class,x)).collect(Collectors.toList());
    }
}
