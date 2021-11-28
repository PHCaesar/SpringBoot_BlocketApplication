package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.function.Predicate;

@Entity
@NoArgsConstructor
public class Mob {

    private long id;
    private String name;
    private List<Item> drops;
    private MobType type;

    Predicate<MobType> isFriendly = vl -> vl.equals(MobType.FRIENDLY);
    Predicate<MobType> isAggressive = vl -> vl.equals(MobType.AGGRESSIVE);
    Predicate<List<Item>> hasDrops = vl -> vl.size()!=0;


    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public List<Item> getDrops() { return drops; }
    public void setDrops(List<Item> drops) { this.drops = drops; }
    public MobType getType() { return type; }
    public void setType(MobType type) { this.type = type; }
}
