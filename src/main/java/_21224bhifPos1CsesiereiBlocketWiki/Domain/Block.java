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

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Blocks")
public class Block extends Item{

    private int blockDurability;

}
