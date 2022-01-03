package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.function.Predicate;

/*
 * @Author: Cse19455
 *
 * Item Model Class
 */

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

@Table(name = "Items")

public class Item {

    private Long id;
    private String name;
    private int size;

    @Id @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
