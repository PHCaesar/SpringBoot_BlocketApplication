package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.NonPlayerCharacter;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;

import java.time.LocalDateTime;
import java.util.List;

public record NonPlayerCharacterDto (String nanoId,String name, float health , List<UsableItem> shopitems , LocalDateTime created_at, String token){
    public NonPlayerCharacterDto(NonPlayerCharacter nonPlayerCharacter){
        this(nonPlayerCharacter.getNanoId(), nonPlayerCharacter.getName(),nonPlayerCharacter.getHealth(),nonPlayerCharacter.getShopItems(),nonPlayerCharacter.getCreated_at(), nonPlayerCharacter.getToken());
    }
}
