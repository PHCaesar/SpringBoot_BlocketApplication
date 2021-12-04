package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.Predicate;

/*
 * @Author : Cse19455@spengergasse.at
 *
 * Weapon Model Class
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {

    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int damage;
    @Getter @Setter
    private WeaponClass classification;

    Predicate<Integer> hasHighDamage = vl -> vl>100;

    //I don't really know if these are necesssary (Because of the classification getter)
    Predicate<WeaponClass> isBender = vl -> vl.equals(WeaponClass.BENDER);
    Predicate<WeaponClass> isMage = vl -> vl.equals(WeaponClass.MAGE);
    Predicate<WeaponClass> isMelee = vl -> vl.equals(WeaponClass.MELEE);
    Predicate<WeaponClass> isRanged = vl -> vl.equals(WeaponClass.RANGED);

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
