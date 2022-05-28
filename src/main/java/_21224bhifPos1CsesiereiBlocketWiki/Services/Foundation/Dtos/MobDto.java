package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;

import java.time.LocalDateTime;
import java.util.List;

public record MobDto (String nanoId,String name, List<UsableItem> drops, MobType type, LocalDateTime created_at, String token){
    public  MobDto(Mob mob){
        this(mob.getNanoId(),mob.getName(),mob.getDrops(),mob.getType(),mob.getCreated_at(),mob.getToken());
    }
}