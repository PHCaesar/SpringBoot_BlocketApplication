package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.function.Predicate;

/*
 * @Author : Cse19455@spengergasse.at
 *
 * Mob Model Class
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mob {

    private long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private List<Item> drops;

    @Getter @Setter
    private MobType type;

    Predicate<MobType> isFriendly = vl -> vl.equals(MobType.FRIENDLY);
    Predicate<MobType> isAggressive = vl -> vl.equals(MobType.AGGRESSIVE);
    Predicate<List<Item>> hasDrops = vl -> vl.size()!=0;

    @Id @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
