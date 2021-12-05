package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.function.Predicate;

/*
 * @Author: SIE19038@spengergasse.at
 * @Name: Bernhard Siegl
 *
 * Block Model Class
 */

@Entity
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor

@Table(name = "Blocks")
public class Block extends Item{

    @Getter @Setter @Column(name = "durability")
    private int blockDurability;

}
