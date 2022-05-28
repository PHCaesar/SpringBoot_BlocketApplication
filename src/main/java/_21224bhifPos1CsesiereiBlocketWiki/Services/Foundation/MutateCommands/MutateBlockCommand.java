package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MutateBlockCommand {
    private String nanoId;
    private LocalDateTime created_at;
    private int blockDurability;
    private String name;
    private String blockName;
    private int size;
    private String token;

}
