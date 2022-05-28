package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class MutateSurnameCommand {
    private String nanoId;
    private LocalDateTime created_at;
    private String name;
    private String token;
}
