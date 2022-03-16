package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepositoryCustom {
    void insert(Block block);

    Block findByName(String name);
    List<Block> findByBlocksDurability(int blockDurability);
}
