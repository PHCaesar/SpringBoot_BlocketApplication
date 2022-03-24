package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepositoryCustom {
    void insert(GameUser gameUser);

    List<GameUser> findByBirthDateAfter(LocalDate birthDate);
    List<GameUser> findByBirthDateBefore(LocalDate birthDate);
    GameUser findByFirstnameAndUsername(String firstname, String username);
    GameUser findByFirstnameAndSurnames(String firstname, List<Surname> surnames);
}
