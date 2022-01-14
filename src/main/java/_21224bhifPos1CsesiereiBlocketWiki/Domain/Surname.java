package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/*
 * @Author : [Philipp.cserich@gmail.com]
 *
 * Surname Model Class
 */

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Surname extends AbstractPersistable<Long> {

    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

