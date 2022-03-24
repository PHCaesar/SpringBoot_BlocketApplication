package _21224bhifPos1CsesiereiBlocketWiki.persistence;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Weapon;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon,Long>,
        QuerydslPredicateExecutor<Weapon>,
        WeaponRepositoryCustom {

    Weapon findByName(String name);
    List<Weapon> findByClassification(WeaponClass classification);
    List<Weapon> findByDamageLower(int damage);
    List<Weapon> findByDamageHigher(int damage);
}
