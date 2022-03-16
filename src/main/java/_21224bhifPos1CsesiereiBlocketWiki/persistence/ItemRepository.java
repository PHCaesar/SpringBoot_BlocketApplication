package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> ,
        QuerydslPredicateExecutor<Item> ,
        ItemRepositoryCustom
{

    Item findByItemID(int id);
    Item findByName(String name);
    List<Item> findBySizeAfter(int size);
    List<Item> findBySizeBefore(int size);

}
