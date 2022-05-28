package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import _21224bhifPos1CsesiereiBlocketWiki.Domain.Surname;

import java.time.LocalDateTime;


public record SurnameDto (String nanoId,String name , LocalDateTime created_at) {
    public SurnameDto(Surname surname){
        this(surname.getNanoId(), surname.getName(),surname.getCreated_at());
    }
}
