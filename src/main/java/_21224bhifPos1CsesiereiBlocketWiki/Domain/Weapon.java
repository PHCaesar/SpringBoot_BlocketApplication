package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.function.Predicate;

/*
 * @Author : Cse19455@spengergasse.at
 *
 * Weapon Model Class
 */

@Entity
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor

@Table(name = "Weapons")

public class Weapon extends Item {

    @Getter @Setter @Column(name = "description")
    private String description;
    @Getter @Setter @Column(name = "damage")
    private int damage;
    @Getter @Setter @Embedded @Column(name = "weapon-class")
    private WeaponClass classification;

}
