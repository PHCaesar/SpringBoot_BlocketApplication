package _21224bhifPos1CsesiereiBlocketWiki.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NonPlayerCharacter {

    private String name;
    @Getter @Setter
    private float health;
    @Getter @Setter
    private List<Item> shopItems;

    @Id
    @GeneratedValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
