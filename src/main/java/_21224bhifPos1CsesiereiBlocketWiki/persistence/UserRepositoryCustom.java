package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepositoryCustom {
    void insert(User user);

    List<User> findByBirthDateAfter(LocalDate birthDate);
    List<User> findByBirthDateBefore(LocalDate birthDate);
    User findByFirstnameAndUsername(String firstname, String username);
    User findByFirstnameAndSurnames(String firstname, List<Surname> surnames);
}
