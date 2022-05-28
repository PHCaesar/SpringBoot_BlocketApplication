package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.GameUser;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record GameUserDto(String nanoId,LocalDateTime localDateTime, List<Surname> surnames , String firstname, String name, String username,
                         LocalDate birthDate,String token){
    public GameUserDto(GameUser gameUser){
        this(gameUser.getNanoId(),gameUser.getCreated_at(),gameUser.getSurnames(), gameUser.getFirstname(), gameUser.getName(), gameUser.getUsername(), gameUser.getBirthDate(), gameUser.getToken());
    }
}
