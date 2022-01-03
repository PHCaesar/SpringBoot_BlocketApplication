package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.function.Predicate;

/*
 * @Author: Cse19455
 *
 * GameContent Model Class
 */

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

@Table(name = "GameContents")
public class GameContent {

    @Id @GeneratedValue
    private Long id;
    @OneToMany
    private List<Item> itemsInGame;
    @OneToMany
    private List<Mob> mobsInGame;
    @OneToMany
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
    @OneToOne
    private User loggedInUser;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
