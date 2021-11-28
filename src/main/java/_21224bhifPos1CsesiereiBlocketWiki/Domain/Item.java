package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.Predicate;

@NoArgsConstructor
public class Item {

    private Long id;
    private String name;
    private int size;

    Predicate<String> hasName = vl -> !vl.isBlank();
    Predicate<Integer> hasSize = vl -> vl.intValue()!=0;

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
}
