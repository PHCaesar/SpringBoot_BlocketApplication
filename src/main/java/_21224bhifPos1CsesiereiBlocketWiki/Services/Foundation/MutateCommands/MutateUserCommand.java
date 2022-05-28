package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.MutateCommands;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Permission;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class MutateUserCommand {
    private List<Surname> surnames;
    private String firstname,name,username;
    private LocalDate birthDate;
    private List<Permission> permissions;
    private String token;
}
