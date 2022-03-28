package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateBlockCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block,Long>,
        QuerydslPredicateExecutor<Block>,
        BlockRepositoryCustom
{
    List<Block> ListAll();
    Block findByDTO(BlockDto mutateBlockCommand);
    List<Block> findByBlocksDurability(int blockDurability);
    Block deleteBlock(Block block);
}
