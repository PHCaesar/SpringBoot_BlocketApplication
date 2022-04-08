package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record NonPlayerCharacterDto (Long id, float health , List<UsableItem> shopitems , LocalDateTime created_at){
    public NonPlayerCharacterDto(NonPlayerCharacter nonPlayerCharacter){
        this(nonPlayerCharacter.getId(),nonPlayerCharacter.getHealth(),nonPlayerCharacter.getShopItems(),nonPlayerCharacter.getCreated_at());
    }
}
