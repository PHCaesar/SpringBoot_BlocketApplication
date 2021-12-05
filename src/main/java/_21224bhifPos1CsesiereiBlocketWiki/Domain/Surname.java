package _21224bhifPos1CsesiereiBlocketWiki.Domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * @Author : Cse19455@spengergasse.at
 *
 * Surname Model Class
 */

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@Builder

@Embeddable
public class Surname {

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
