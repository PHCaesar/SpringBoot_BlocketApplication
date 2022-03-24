package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
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
    public UsableItem(String name,int size){super(name,size);}
    private String description;
}
