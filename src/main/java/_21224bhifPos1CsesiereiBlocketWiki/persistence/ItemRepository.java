package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<UsableItem,Long> ,
        QuerydslPredicateExecutor<UsableItem> ,
        ItemRepositoryCustom
{

    UsableItem findByItemID(int id);
    UsableItem findByName(String name);
    List<UsableItem> findBySizeAfter(int size);
    List<UsableItem> findBySizeBefore(int size);

}
