package _21224bhifPos1CsesiereiBlocketWiki.Services.Interfaces;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos.GameUserDto;

import java.util.List;

public interface IUserService {
    public GameUser getUserByName(GameUserDto user);
    public List<GameUser> getAllUser();
    public GameUser insertUser(GameUserDto user);
    public GameUser updateUser(GameUserDto user);
    public void deleteUser(GameUserDto user);
    public void deleteAll();
}
