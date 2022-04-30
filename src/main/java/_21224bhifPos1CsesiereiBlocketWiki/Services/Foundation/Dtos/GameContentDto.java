package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;

import java.time.LocalDateTime;
import java.util.List;

public record GameContentDto(List<UsableItem> items, List<Block> blocks, List<Weapon> weapons, List<Mob> mobs, List<NonPlayerCharacter> npcs, GameUser user,
                             LocalDateTime created_at) {
    public GameContentDto(GameContent gc){
        this(gc.getItemsInGame(),gc.getBlocksInGame(),gc.getWeaponsInGame(),gc.getMobsInGame(),gc.getNonPlayerCharactersInGame(),gc.getLoggedInGameUser(),gc.getCreated_at());
    }
}
