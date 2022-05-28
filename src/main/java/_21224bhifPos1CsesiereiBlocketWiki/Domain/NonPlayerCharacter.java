package _21224bhifPos1CsesiereiBlocketWiki.Domain;


import lombok.*;
import org.hibernate.tuple.entity.AbstractEntityBasedAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * NonPlayerCharacter Model Class
 */

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "NonPlayerCharacters")
public class NonPlayerCharacter extends AbstractPersistable<Long> {
    private String nanoId;
    private LocalDateTime created_at;
    private String name;
    private float health;
    @OneToMany(targetEntity = UsableItem.class,fetch = FetchType.EAGER)
    private List<UsableItem> shopItems;
    private String token;
}
