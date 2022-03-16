package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> ,
        QuerydslPredicateExecutor<User>,
        UserRepositoryCustom{

    List<User> findByBirthDateAfter(LocalDate birthDate);
    List<User> findByBirthDateBefore(LocalDate birthDate);
    User findByFirstnameAndUsername(String firstname, String username);
    User findByFirstnameAndSurnames(String firstname, List<Surname> surnames);

}
