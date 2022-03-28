package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MobDto implements Serializable {
    private final Long id;
    private final String name;
    private final List<UsableItemDto> drops;
    private final MobType type;
    private final LocalDateTime created_at;
    private final String token;
}
