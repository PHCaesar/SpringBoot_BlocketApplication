package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
public class Mob {

    private Long id;
    private String name;
    private List<Item> drops;
    private MobType type;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }


}
