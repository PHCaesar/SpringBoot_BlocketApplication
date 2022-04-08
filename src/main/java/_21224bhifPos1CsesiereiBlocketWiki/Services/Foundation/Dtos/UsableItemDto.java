package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record UsableItemDto(String name , int size , LocalDateTime created_at , String description , String token) {
        public UsableItemDto(UsableItem usableItem){
            this(usableItem.getName(), usableItem.getSize(), usableItem.getCreated_at(), usableItem.getDescription(), usableItem.getToken());
        }
}
