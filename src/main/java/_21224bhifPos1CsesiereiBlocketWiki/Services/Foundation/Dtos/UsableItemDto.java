package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class UsableItemDto implements Serializable {

    private final int blockDurability;
    private final String name;
    private final int size;
    private final LocalDateTime created_at;
    private final String description;
    private final String token;
}
