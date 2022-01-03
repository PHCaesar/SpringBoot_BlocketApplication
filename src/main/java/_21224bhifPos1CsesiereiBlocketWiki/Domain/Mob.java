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
@Data
@NoArgsConstructor @AllArgsConstructor

@Table(name = "Mobs")

public class Mob {

    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private List<Item> drops;
    @Embedded
    private MobType type;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
