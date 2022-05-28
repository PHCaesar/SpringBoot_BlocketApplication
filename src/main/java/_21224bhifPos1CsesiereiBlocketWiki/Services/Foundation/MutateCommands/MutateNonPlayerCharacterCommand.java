package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.UsableItem;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class MutateNonPlayerCharacterCommand {
    private String nanoId;
    private LocalDateTime created_at;
    private String name;
    private float health;
    private List<UsableItem> shopItems;
    private String token;
}
