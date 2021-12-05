package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.Predicate;

@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int size;

    Predicate<String> hasName = vl -> !vl.isBlank();
    Predicate<Integer> hasSize = vl -> vl.intValue()!=0;

    @Id @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
