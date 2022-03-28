package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MutateWeaponCommand {

    private LocalDateTime created_at;
    private String description;
    private int damage;
    private WeaponClass classification;
    private String token;
}
