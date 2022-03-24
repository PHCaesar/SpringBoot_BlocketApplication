package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Permission;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;

import java.time.LocalDate;
import java.util.List;

public class MutateUserCommand {
    public List<Surname> surnames;
    public String firstname,name,username;
    public LocalDate birthDate;
    public List<Permission> permissions;
}
