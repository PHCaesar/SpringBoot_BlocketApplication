package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Mob;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record MobDto (Long id, String name, List<UsableItem> drops, MobType type, LocalDateTime created_at, String token){
    public  MobDto(Mob mob){
        this(mob.getId(),mob.getName(),mob.getDrops(),mob.getType(),mob.getCreated_at(),mob.getToken());
    }
}
