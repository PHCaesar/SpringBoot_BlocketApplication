package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.function.Predicate;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * Mob Model Class
 */

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Mobs")
public class Mob extends AbstractPersistable<Long> {

    private String name;
    @OneToMany
    private List<Item> drops;
    @Embedded
    private MobType type;

}
