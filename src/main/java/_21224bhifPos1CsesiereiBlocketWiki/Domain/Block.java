package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.Predicate;

@Entity
@NoArgsConstructor
public class Block {

    private long id;
    private String name;
    private int size;
    private int blockDurability;

    Predicate<String> hasName = vl -> !vl.isBlank();
    Predicate<Integer> hasSize = vl -> vl.intValue()!=0;
    Predicate<Integer> hasBlockDurability = vl -> vl.intValue()!=0;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getBlockDurability() {
        return blockDurability;
    }
    public void setBlockDurability(int blockDurability) {
        this.blockDurability = blockDurability;
    }
}
