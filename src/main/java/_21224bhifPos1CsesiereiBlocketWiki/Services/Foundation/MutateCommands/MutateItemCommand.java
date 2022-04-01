package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MutateItemCommand {
    private LocalDateTime created_at;
    private String name;
    private int size;
    private String token;
}
