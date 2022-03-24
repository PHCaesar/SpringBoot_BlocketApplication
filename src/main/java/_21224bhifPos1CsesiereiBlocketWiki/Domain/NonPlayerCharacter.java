package _21224bhifPos1CsesiereiBlocketWiki.Domain;


import lombok.*;
import org.hibernate.tuple.entity.AbstractEntityBasedAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
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
public class NonPlayerCharacter extends AbstractPersistable<String> {

    private float health;
    @OneToMany(targetEntity = UsableItem.class,fetch = FetchType.EAGER)
    private List<UsableItem> shopItems;
}
