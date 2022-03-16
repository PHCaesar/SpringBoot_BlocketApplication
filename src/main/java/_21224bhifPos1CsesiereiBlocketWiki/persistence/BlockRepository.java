package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block,Long>,
        QuerydslPredicateExecutor<Block>,
        BlockRepositoryCustom
{
    Block findByName(String name);
    List<Block> findByBlocksDurability(int blockDurability);
}
