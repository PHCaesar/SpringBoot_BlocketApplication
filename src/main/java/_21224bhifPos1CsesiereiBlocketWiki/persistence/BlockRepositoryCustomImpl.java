package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateBlockCommand;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    public Block findById(int id) {
        Query sqlQuery = entityManager.createQuery("SELECT id FROM Block WHERE id = :id");
        sqlQuery.setParameter("id", id);

        return entityManager.find(Block.class, sqlQuery);
    }

    @Override
    public List<Block> ListAll() {
        List<Long> ids = entityManager.createQuery("SELECT id FROM Block").getResultList();
        return ids.stream().map(x-> entityManager.find(Block.class,x)).collect(Collectors.toList());
    }

    @Override
    public Block findByDTO(BlockDto mutateBlockCommand){
        Query sqlQuery = entityManager.createQuery("SELECT id FROM Block WHERE blockDurability = :blockdurability AND blockname = :blockname");
        sqlQuery.setParameter("blockdurability", mutateBlockCommand.blockDurability()).setParameter("blockname", mutateBlockCommand.blockname());
        try {
            return entityManager.find(Block.class, sqlQuery.getSingleResult());
        }catch (Exception e){return null;}
    }

    @Override
    public List<Block> findByBlocksDurability(int blockDurability) {
        Query sqlQuery = entityManager.createQuery("SELECT id FROM Block WHERE blockDurability = :blockDurability");
        sqlQuery.setParameter("blockDurability", blockDurability);

        List<Long> ids = sqlQuery.getResultList();
        return ids.stream().map(x-> entityManager.find(Block.class,x)).collect(Collectors.toList());
    }

    @Override
    public Block deleteBlock(Block block) {
        entityManager.remove(block);
        return block;
    }
}
