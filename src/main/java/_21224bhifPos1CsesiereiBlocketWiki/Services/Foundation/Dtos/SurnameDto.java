package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import lombok.Builder;
import lombok.Data;
import _21224bhifPos1CsesiereiBlocketWiki.Domain.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record SurnameDto (Long id, String name , LocalDateTime created_at) {
    public SurnameDto(Surname surname){
        this(surname.getId(),surname.getName(),surname.getCreated_at());
    }
}
