package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Predicate;

/*
 * @Author: SIE19038@spengergasse.at
 * @Name: Bernhard Siegl
 *
 * Block Model Class
 */

@Entity
@Table(name = "Blocks")
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class Block extends Item
{
    private String nanoId;
    private String name;
    private int size;
    private LocalDateTime created_at;
    private int blockDurability;
    private String blockname;
    private String token;
}
