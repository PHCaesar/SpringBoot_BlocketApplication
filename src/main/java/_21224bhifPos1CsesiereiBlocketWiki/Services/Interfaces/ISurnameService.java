package _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.SurnameDto;

public interface ISurnameService {
    public Surname getByName(String name);
    public Surname insertSurname(SurnameDto srn);
    public Surname updateSurname(SurnameDto srn);
    public void deleteSurname(SurnameDto srn);
    public void deleteAll();
}
