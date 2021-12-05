package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.function.Predicate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GameContent {

    private Long id;
    @Getter @Setter
    private List<Item> itemsInGame;
    @Getter @Setter
    private List<Mob> mobsInGame;
    @Getter @Setter
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
    @Getter @Setter
    private User loggedInUser;

    Predicate<List<Item>> hasItems = vl -> vl.size()!=0;
    Predicate<List<Mob>> hasMobs = vl -> vl.size()!=0;
    Predicate<List<NonPlayerCharacter>> hasNonPlayerCharacters = vl -> vl.size()!=0;
    Predicate<List<User>> hasUser = vl -> vl.size()!=0;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
