package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class NonPlayerCharacterDto implements Serializable {
    private final Long id;
    private final float health;
    private final List<UsableItemDto> shopItems;
    private final LocalDateTime created_at;
}
