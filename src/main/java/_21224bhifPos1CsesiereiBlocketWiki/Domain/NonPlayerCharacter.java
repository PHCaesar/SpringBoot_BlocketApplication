package _21224bhifPos1CsesiereiBlocketWiki.Domain;


import lombok.*;
import javax.persistence.*;
import java.util.List;

/*
 * @Author : Cse19455@spengergasse.at
 *
 * NonPlayerCharacter Model Class
 */

@Entity
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor

@Table(name = "NonPlayerCharacters")

public class NonPlayerCharacter {


    private String name;
    @Getter @Setter @Column(name = "health")
    private float health;
    @Getter @Setter @OneToMany @Column(name = "items")
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
