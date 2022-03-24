package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/*
 * @Author: [Philipp.cserich@gmail.com]
 *
 * GameContent Model Class
 */

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "GameContents")
public class GameContent extends AbstractPersistable<Long> {

    @OneToMany(targetEntity = UsableItem.class)
    private List<UsableItem> itemsInGame;
    @OneToMany(targetEntity = Block.class)
    private List<Block> blocksInGame;
    @OneToMany(targetEntity = Weapon.class)
    private List<Weapon> weaponsInGame;
    @OneToMany(targetEntity = Mob.class)
    private List<Mob> mobsInGame;
    @OneToMany(targetEntity = NonPlayerCharacter.class)
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
    @OneToOne(targetEntity = GameUser.class)
    private GameUser loggedInGameUser;

}
