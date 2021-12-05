package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.Predicate;

/*
 * @Author: SIE19038@spengergasse.at
 * @Name: Bernhard Siegl
 *
 * Block Model Class
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    private long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int size;
    @Getter @Setter
    private int blockDurability;

    Predicate<String> hasName = vl -> !vl.isBlank();
    Predicate<Integer> hasSize = vl -> vl.intValue()!=0;
    Predicate<Integer> hasBlockDurability = vl -> vl.intValue()!=0;

    @Id @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
