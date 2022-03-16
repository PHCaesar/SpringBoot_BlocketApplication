package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurnameRepositoryCustom {
    void insert(Surname surname);

    Surname findByName(String name);
}
