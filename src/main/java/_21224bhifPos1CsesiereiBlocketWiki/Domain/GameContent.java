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
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor

@Table(name = "GameContents")
public class GameContent {

    @Id @GeneratedValue
    private Long id;
    @Getter @Setter @OneToMany @Column(name = "items")
    private List<Item> itemsInGame;
    @Getter @Setter @OneToMany @Column(name = "mobs")
    private List<Mob> mobsInGame;
    @Getter @Setter @OneToMany @Column(name = "nonplayercharacter")
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
    @Getter @Setter @OneToOne @Column(name = "user")
    private User loggedInUser;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
