package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurnameRepository extends JpaRepository<Surname,Long>,
        QuerydslPredicateExecutor<Surname>,
        SurnameRepositoryCustom{

    Surname findByName(String name);

}
