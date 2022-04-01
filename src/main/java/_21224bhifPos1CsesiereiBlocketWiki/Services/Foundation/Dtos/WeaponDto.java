package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class WeaponDto implements Serializable {
    private final String description;
    private final int damage;
    private final WeaponClass classification;
    private final int blockDurability;
    private final String name;
    private final int size;
    private final LocalDateTime created_at;
}
