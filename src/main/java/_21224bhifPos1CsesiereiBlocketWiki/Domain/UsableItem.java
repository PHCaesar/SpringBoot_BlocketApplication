package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Predicate;

/*
 * @Author: [Philipp.cserich@gmail.com]
 *
 * Item Model Class
 */

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "UsableItems")
public class UsableItem extends Item {
    private LocalDateTime created_at;
    private String description;
    private String token;
    private String name;
    private int size;
    @ManyToOne
    private Mob mob;
    @ManyToOne
    private NonPlayerCharacter nonPlayerCharacter;
}
