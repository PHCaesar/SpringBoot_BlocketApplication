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
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Items")
public class Item extends AbstractPersistable<Long> {

    private String name;
    private int size;

}
