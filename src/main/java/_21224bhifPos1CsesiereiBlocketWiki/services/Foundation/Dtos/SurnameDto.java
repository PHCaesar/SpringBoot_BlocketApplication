package _21224bhifPos1CsesiereiBlocketWiki.Services.Foundation.Dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class SurnameDto implements Serializable {
    private final Long id;
    private final String name;
    private final LocalDateTime created_at;
}
