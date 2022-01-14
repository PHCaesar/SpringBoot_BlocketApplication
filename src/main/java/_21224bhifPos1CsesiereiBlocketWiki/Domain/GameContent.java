package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.function.Predicate;

/*
 * @Author: [Philipp.cserich@gmail.com]
 *
 * GameContent Model Class
 */

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "GameContents")
public class GameContent extends AbstractPersistable<Long> {

    @OneToMany
    private List<Item> itemsInGame;
    @OneToMany
    private List<Mob> mobsInGame;
    @OneToMany
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
    @OneToOne
    private User loggedInUser;

}
