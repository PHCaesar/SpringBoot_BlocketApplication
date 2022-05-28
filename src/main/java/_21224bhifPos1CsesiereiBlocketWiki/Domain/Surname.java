package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * Surname Model Class
 */

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Surname extends AbstractPersistable<Long> {
    private String nanoId;
    private LocalDateTime created_at;
    private String name;
    private String token;
}

