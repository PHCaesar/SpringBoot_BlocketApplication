package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.BlockDto;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands.MutateBlockCommand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepositoryCustom {
    void insert(Block block);

    Block findById(int id);
    List<Block> ListAll();
    Block findByDTO(BlockDto mutateBlockCommand);
    List<Block> findByBlocksDurability(int blockDurability);
    Block deleteBlock(Block block);
}
