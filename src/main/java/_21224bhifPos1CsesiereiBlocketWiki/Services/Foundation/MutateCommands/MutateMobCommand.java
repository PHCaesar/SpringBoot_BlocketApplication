package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.MobType;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@Data
public class MutateMobCommand {
    private String name;
    private List<UsableItem> drops;
    private MobType type;
}
