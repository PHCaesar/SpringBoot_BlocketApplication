package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.hibernate.engine.internal.Cascade;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * Mob Model Class
 */

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Mobs")
public class Mob extends AbstractPersistable<Long> {
    private String nanoId;
    private LocalDateTime created_at;
    private String name;
    @OneToMany(targetEntity = UsableItem.class,fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<UsableItem> drops;
    //@Embedded
    @Enumerated(EnumType.STRING)
    private MobType type;
    private String token;

}
