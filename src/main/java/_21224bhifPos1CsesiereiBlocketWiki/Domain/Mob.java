package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.function.Predicate;

/*
 * @Author : Cse19455@spengergasse.at
 *
 * Mob Model Class
 */

@Entity
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor

@Table(name = "Mobs")

public class Mob {

    @Id @GeneratedValue
    private Long id;
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter
    @OneToMany @Column(name = "drops")
    private List<Item> drops;
    @Getter @Setter @Embedded @Column(name = "mobtype")
    private MobType type;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
