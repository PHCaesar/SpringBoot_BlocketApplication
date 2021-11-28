package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.NoArgsConstructor;

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
public class Weapon {

    private Long id;
    private String name;
    private int damage;
    private WeaponClass classification;

    Predicate<Integer> hasHighDamage = vl -> vl>100;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public WeaponClass getClassification() {
        return classification;
    }
    public void setClassification(WeaponClass classification) {
        this.classification = classification;
    }
}
