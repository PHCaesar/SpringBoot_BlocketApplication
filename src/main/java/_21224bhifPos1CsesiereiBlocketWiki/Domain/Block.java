package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.function.Predicate;

/*
 * @Author: SIE19038@spengergasse.at
 * @Name: Bernhard Siegl
 *
 * Block Model Class
 */

@Entity
@Table(name = "Blocks")
@NoArgsConstructor @AllArgsConstructor
@Data
public class Block extends Item
{
    public Block(String name,int size) {super(name,size);}
    private int blockDurability;
}
