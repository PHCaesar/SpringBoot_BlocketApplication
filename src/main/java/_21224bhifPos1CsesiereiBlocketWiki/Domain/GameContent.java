package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
public class GameContent {

    private Long id;
    private List<Item> itemsInGame;
    private List<Mob> mobsInGame;
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
    private User loggedInUser;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
