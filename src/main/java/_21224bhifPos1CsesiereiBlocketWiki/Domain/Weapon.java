package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Predicate;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * Weapon Model Class
 */

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Weapons")
@Builder
public class Weapon extends Item {
    private String nanoId;
    private LocalDateTime created_at;
    private String description;
    private int damage;
    private String token,name;

    @Enumerated(EnumType.STRING)
    private WeaponClass classification;

}
