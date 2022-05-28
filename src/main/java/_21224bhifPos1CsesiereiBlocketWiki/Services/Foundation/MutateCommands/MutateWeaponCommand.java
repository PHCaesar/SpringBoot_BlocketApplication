package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.WeaponClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MutateWeaponCommand {
    private String description;
    private String name;
    private int damage;
    private int size;
    private WeaponClass classification;
}
