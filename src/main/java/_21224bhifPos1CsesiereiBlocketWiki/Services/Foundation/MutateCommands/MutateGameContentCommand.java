package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class MutateGameContentCommand {
    private String nanoId;
    private LocalDateTime created_at;
    private List<UsableItem> itemsInGame;
    private List<Block> blocksInGame;
    private List<Weapon> weaponsInGame;
    private List<Mob> mobsInGame;
    private List<NonPlayerCharacter> nonPlayerCharactersInGame;
    private GameUser loggedInGameUser;
    private String token;
}
