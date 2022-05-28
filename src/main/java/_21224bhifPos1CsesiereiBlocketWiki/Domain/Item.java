package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Item extends AbstractPersistable<Long> {
    private String nanoId;
    private String name;
    private int size;
    //@ManyToOne(cascade = CascadeType.REFRESH)
    //private Mob mob;
}
