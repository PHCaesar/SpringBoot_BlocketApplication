package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.function.Predicate;

@Entity
@NoArgsConstructor
public class GameContent {

    private Long id;

    private List<Item> itemsInGame;
    private List<Mob> mobsInGame;
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
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

    public List<Item> getItemsInGame() {
        return itemsInGame;
    }
    public void setItemsInGame(List<Item> itemsInGame) {
        this.itemsInGame = itemsInGame;
    }
    public List<Mob> getMobsInGame() {
        return mobsInGame;
    }
    public void setMobsInGame(List<Mob> mobsInGame) {
        this.mobsInGame = mobsInGame;
    }
    public List<NonPlayerCharacter> getNonPlayerCharactersInGame() {
        return nonPlayerCharactersInGame;
    }
    public void setNonPlayerCharactersInGame(List<NonPlayerCharacter> nonPlayerCharactersInGame) {
        this.nonPlayerCharactersInGame = nonPlayerCharactersInGame;
    }
    public User getLoggedInUser() {
        return loggedInUser;
    }
    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


}
